package com.wavesplatform.datafeed

import java.io.File

import com.typesafe.config.ConfigFactory
import com.wavesplatform.datafeed.model._
import com.wavesplatform.datafeed.api._
import com.wavesplatform.datafeed.settings._
import com.wavesplatform.datafeed.utils._
import akka.actor._
import akka.actor.{ActorRef, ActorSystem}
import akka.stream.scaladsl._
import akka.stream.scaladsl.Flow
import akka.http.scaladsl.model.ws._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.reflect.runtime.universe._
import akka.stream.ActorMaterializer
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import com.wavesplatform.datafeed.api.WebSocketSubscriber.RegisterSource


class Application(as: ActorSystem, wdfSettings: WDFSettings) extends {

}



object Application extends Logging {


  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem("wavesdatafeed")
    implicit val materializer = ActorMaterializer()

    val maybeConfigFile = for {
      maybeFilename <- args.headOption
      file = new File(maybeFilename)
      if file.exists
    } yield file

    val config =
    maybeConfigFile match {
      case Some(file) => ConfigFactory.parseFile(file).withFallback(ConfigFactory.load())
      case None => {
        log.warn("Starting with default settings...")
        ConfigFactory.load()
      }
    }

    val settings = WDFSettings.fromConfig(config)

    if (!settings.enable) {
      log.info("DataFeed not enabled. Exiting..")
      sys.exit(1)
    }

    log.info("Starting Waves Data Feed...")

    val application = new Application(system, settings)

    val nodeApi = NodeApiWrapper(settings)

    val uetx = new UnconfirmedETX
    val router: ActorRef = system.actorOf(Props[WebSocketRouter], "router")

    val timeseries = new TimeSeries(settings, nodeApi, uetx)

    val synchronizer = system.actorOf(Props(classOf[Synchronizer], nodeApi, uetx, timeseries, router, settings.matchers), name = "nodeSync")


    lazy val apiController = ApiController(settings, timeseries, router)

    lazy val datafeedApiRoutes = Seq(
      RestApiRoute(settings, apiController)
    )

    lazy val datafeedApiTypes = Seq(
      typeOf[RestApiRoute]
    )

    val combinedRoute = CompositeHttpService(system, datafeedApiTypes, datafeedApiRoutes, settings).compositeRoute
    val datafeedServerBinding = Await.result(Http().bindAndHandle(combinedRoute, settings.restAddress, settings.restPort), 5.seconds)

    log.info(s"Starting REST API on: ${settings.restAddress}:${settings.restPort} ...")

    if(settings.websocketEnable) {
      log.info(s"Starting WebSocket server on: ${settings.websocketAddress}:${settings.websocketPort} ...")
      val websocketHandler =
        pathSingleSlash {
          get {
            handleWebSocketMessages(Flows.websocketFlow(router, apiController))
          }
        }
      val binding = Http().bindAndHandle(websocketHandler, interface = settings.websocketAddress, port = settings.websocketPort)
    }




    system.scheduler.schedule(0 seconds, 200 millisecond, synchronizer, "sync")

  }

}


object Flows {

  def websocketFlow(router: ActorRef, apiController: ApiController): Flow[Message, Message, _] = {
    val mysink = Sink.actorSubscriber(Props(classOf[WebSocketSubscriber], apiController))
    val mysource = Source.actorPublisher[String](Props(classOf[WebSocketPublisher],router)).map[Message](x => TextMessage.Strict(x))
    Flow.fromSinkAndSourceMat(mysink, mysource)((sinkActor, sourceActor) => {sinkActor ! RegisterSource(sourceActor)})
  }

}


