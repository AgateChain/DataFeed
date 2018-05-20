# Agate Data Feed
Agate Data Feed (ADF) is a REST API and a WebSocket proxy for the Agate Blockchain.
The REST API provides real-time and historical market data in raw or OHLCV (candlestick) formats for unconfirmed and confirmed DEX transactions.
The WebSocket proxy allows you to receive asynchronous notifications of blockchain events.

REST API runs by default on TCP port 6990, WebSocket proxy on TCP port 6991. REST API and WebSocket services can be enabled and configured by editing the ADF configuration file.


## Getting Started

You can start ADF with this command:

    java -jar wdf-1.5.0.jar wdf.conf

Once started, you can access the Swagger UI to browse the API at http://localhost:6990

## Datafeed API

#### Asset symbols
Get list of asset symbols

```
GET /symbols

#Example:
http://localhost:6990/datafeed/symbols
```
Response:
```
[
	{
	  "symbol" : "B@",
	  "assetID" : "APz41KyoKuBBh8t3oZjqvhbbsg6f63tpZM5Ck5LYx6h"
	}, {
	  "symbol" : "BTC",
	  "assetID" : "8LQW8f7P5d5PZM7GtZEBgaqRPGSzS3DfPuiXrURJ4AJS"
	}, {
	  "symbol" : "CNY",
	  "assetID" : "DEJbZipbKQjwEiRjx2AqQFucrj5CZ3rAc4ZvFM8nAsoA"
	}, {
	  "symbol" : "EFYT",
	  "assetID" : "725Yv9oceWsB4GsYwyy4A52kEwyVrL5avubkeChSnL46"
	}, {
	  "symbol" : "ETT",
	  "assetID" : "8ofu3VpEaVCFjRqLLqzTMNs5URKUUQMrPp3k6oFmiCc6"
	}, {
	  "symbol" : "EUR",
	  "assetID" : "Gtb1WRznfchDnTh37ezoDTJ4wcoKaRsKqKjJjy7nm2zU"
	}, {
	  "symbol" : "INCNT",
	  "assetID" : "FLbGXzrpqkvucZqsHDcNxePTkh2ChmEi4GdBfDRRJVof"
	}, {
	  "symbol" : "KLN",
	  "assetID" : "EYz8Zvs62D4d7F5ZgXHCWuzuFaZg63FYnfVQrTWQoLSK"
	}, {
	  "symbol" : "MER",
	  "assetID" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj"
	}, {
	  "symbol" : "MGO",
	  "assetID" : "2Y8eFFXDTkxgCvXbMT5K4J38cpDYYbQdciJEZb48vTDj"
	}, {
	  "symbol" : "MRT",
	  "assetID" : "4uK8i4ThRGbehENwa6MxyLtxAjAo1Rj9fduborGExarC"
	}, {
	  "symbol" : "PBKX",
	  "assetID" : "39wcSXj4MdRNRJXA88rVxF7EXWjYixaA3J3EteoN6DMM"
	}, {
	  "symbol" : "PING",
	  "assetID" : "Bi4w2UuGRt2jAJFfRb8b3SwDUV5x8krCzX2zZHcRfPNc"
	}, {
	  "symbol" : "RBX",
	  "assetID" : "AnERqFRffNVrCbviXbDEdzrU6ipXCP5Y1PKpFdRnyQAy"
	}, {
	  "symbol" : "TKS",
	  "assetID" : "BDMRyZsmDZpgKhdM7fUTknKcUbVVkDpMcqEj31PUzjMy"
	}, {
	  "symbol" : "UPC",
	  "assetID" : "4764Pr9DpKQAHAjAVA2uqnrYidLMnM7vpDDLCDWujFTt"
	}, {
	  "symbol" : "USD",
	  "assetID" : "Ft8X1v1LTa1ABafufpaCWyVj8KkaxUWE6xBhW6sNFJck"
	}, {
	  "symbol" : "AGT",
	  "assetID" : "AGATE"
	}, {
	  "symbol" : "WCT",
	  "assetID" : "DHgwrRvVyqJsepd32YbBqUeDH4GJ1N984X8QoekjgH8J"
	}, {
	  "symbol" : "WGO",
	  "assetID" : "4eT6R8R2XuTcBuTHiXVQsh2dN2mg3c2Qnp95EWBNHygg"
	}, {
	  "symbol" : "WPN",
	  "assetID" : "BkFyeRdrLquxds5FenxyonyfTwMVJJ6o6L7VTaPr5fs3"
	}, {
	  "symbol" : "ZRC",
	  "assetID" : "5ZPuAVxAwYvptbCgSVKdTzeud9dhbZ7vvxHVnZUoxf4h"
	}
]
```

#### Markets
Get list of all traded markets with 24h stats
```
GET /markets

#Example:
http://localhost:6990/datafeed/markets
```
Response:
```
[
    {
      "symbol" : "B@/BTC",
      "amountAssetID" : "APz41KyoKuBBh8t3oZjqvhbbsg6f63tpZM5Ck5LYx6h",
      "amountAssetName" : "B@nkcoin",
      "amountAssetDecimals" : 8,
      "amountAssetTotalSupply" : "25000000.00000000",
      "amountAssetMaxSupply" : "infinite",
      "amountAssetCirculatingSupply" : "11411669.00000000",
      "priceAssetID" : "8LQW8f7P5d5PZM7GtZEBgaqRPGSzS3DfPuiXrURJ4AJS",
      "priceAssetName" : "WBTC",
      "priceAssetDecimals" : 8,
      "priceAssetTotalSupply" : "21000000.00000000",
      "priceAssetMaxSupply" : "21000000.00000000",
      "priceAssetCirculatingSupply" : "1769.00000000",
      "24h_open" : "0.00040000",
      "24h_high" : "0.00040000",
      "24h_low" : "0.00040000",
      "24h_close" : "0.00040000",
      "24h_vwap" : "0.00040000",
      "24h_volume" : "40.00000000",
      "24h_priceVolume" : "0.01600000",
      "totalTrades" : 110,
      "firstTradeDay" : 1493251200000,
      "lastTradeDay" : 1493251308864
    }, {
      "symbol" : "B@/AGT",
      "amountAssetID" : "APz41KyoKuBBh8t3oZjqvhbbsg6f63tpZM5Ck5LYx6h",
      "amountAssetName" : "B@nkcoin",
      "amountAssetDecimals" : 8,
      "amountAssetTotalSupply" : "25000000.00000000",
      "amountAssetMaxSupply" : "infinite",
      "amountAssetCirculatingSupply" : "11411669.00000000",
      "priceAssetID" : "AGATE",
      "priceAssetName" : "AGATE",
      "priceAssetDecimals" : 8,
      "priceAssetTotalSupply" : "100000000.00000000",
      "priceAssetMaxSupply" : "100000000.00000000",
      "priceAssetCirculatingSupply" : "100000000.00000000",
      "24h_open" : "0.33000000",
      "24h_high" : "0.51000000",
      "24h_low" : "0.33000000",
      "24h_close" : "0.39990000",
      "24h_vwap" : "0.46096734",
      "24h_volume" : "3035.53760139",
      "24h_priceVolume" : "1399.28369358",
      "totalTrades" : 112,
      "firstTradeDay" : 1492128000000,
      "lastTradeDay" : 1492128131328
    }, {
      "symbol" : "BTC/EUR",
      "amountAssetID" : "8LQW8f7P5d5PZM7GtZEBgaqRPGSzS3DfPuiXrURJ4AJS",
      "amountAssetName" : "WBTC",
      "amountAssetDecimals" : 8,
      "amountAssetTotalSupply" : "21000000.00000000",
      "amountAssetMaxSupply" : "21000000.00000000",
      "amountAssetCirculatingSupply" : "1769.00000000",
      "priceAssetID" : "Gtb1WRznfchDnTh37ezoDTJ4wcoKaRsKqKjJjy7nm2zU",
      "priceAssetName" : "iEUR",
      "priceAssetDecimals" : 2,
      "priceAssetTotalSupply" : "1000000000.00000000",
      "priceAssetMaxSupply" : "infinite",
      "priceAssetCirculatingSupply" : "110100.00000000",
      "24h_open" : "2228.46",
      "24h_high" : "2231.48",
      "24h_low" : "2200.42",
      "24h_close" : "2231.48",
      "24h_vwap" : "2225.87",
      "24h_volume" : "0.18654724",
      "24h_priceVolume" : "415.22",
      "totalTrades" : 87,
      "firstTradeDay" : 1492473600000,
      "lastTradeDay" : 1492473726144
    }
..
..
]
```

#### Tickers
Get tickers for all traded markets
```
GET /tickers

#Example:
http://localhost:6990/datafeed/tickers
```
Response:
```
[
    {
      "symbol" : "B@/BTC",
      "amountAssetID" : "APz41KyoKuBBh8t3oZjqvhbbsg6f63tpZM5Ck5LYx6h",
      "amountAssetName" : "B@nkcoin",
      "amountAssetDecimals" : 8,
      "amountAssetTotalSupply" : "25000000.00000000",
      "amountAssetMaxSupply" : "infinite",
      "amountAssetCirculatingSupply" : "11411669.00000000",
      "priceAssetID" : "8LQW8f7P5d5PZM7GtZEBgaqRPGSzS3DfPuiXrURJ4AJS",
      "priceAssetName" : "WBTC",
      "priceAssetDecimals" : 8,
      "priceAssetTotalSupply" : "21000000.00000000",
      "priceAssetMaxSupply" : "21000000.00000000",
      "priceAssetCirculatingSupply" : "1769.00000000",
      "24h_open" : "0.00040000",
      "24h_high" : "0.00040000",
      "24h_low" : "0.00040000",
      "24h_close" : "0.00040000",
      "24h_vwap" : "0.00040000",
      "24h_volume" : "40.00000000",
      "24h_priceVolume" : "0.01600000",
      "timestamp" : 1498798060195
    }, {
      "symbol" : "B@/AGATE",
      "amountAssetID" : "APz41KyoKuBBh8t3oZjqvhbbsg6f63tpZM5Ck5LYx6h",
      "amountAssetName" : "B@nkcoin",
      "amountAssetDecimals" : 8,
      "amountAssetTotalSupply" : "25000000.00000000",
      "amountAssetMaxSupply" : "infinite",
      "amountAssetCirculatingSupply" : "11411669.00000000",
      "priceAssetID" : "AGATE",
      "priceAssetName" : "AGATE",
      "priceAssetDecimals" : 8,
      "priceAssetTotalSupply" : "100000000.00000000",
      "priceAssetMaxSupply" : "100000000.00000000",
      "priceAssetCirculatingSupply" : "100000000.00000000",
      "24h_open" : "0.33000000",
      "24h_high" : "0.51000000",
      "24h_low" : "0.33000000",
      "24h_close" : "0.39990000",
      "24h_vwap" : "0.46096734",
      "24h_volume" : "3035.53760139",
      "24h_priceVolume" : "1399.28369358",
      "timestamp" : 1498798060195
    }, {
      "symbol" : "BTC/EUR",
      "amountAssetID" : "8LQW8f7P5d5PZM7GtZEBgaqRPGSzS3DfPuiXrURJ4AJS",
      "amountAssetName" : "WBTC",
      "amountAssetDecimals" : 8,
      "amountAssetTotalSupply" : "21000000.00000000",
      "amountAssetMaxSupply" : "21000000.00000000",
      "amountAssetCirculatingSupply" : "1769.00000000",
      "priceAssetID" : "Gtb1WRznfchDnTh37ezoDTJ4wcoKaRsKqKjJjy7nm2zU",
      "priceAssetName" : "iEUR",
      "priceAssetDecimals" : 2,
      "priceAssetTotalSupply" : "1000000000.00000000",
      "priceAssetMaxSupply" : "infinite",
      "priceAssetCirculatingSupply" : "110100.00000000",
      "24h_open" : "2228.46",
      "24h_high" : "2231.48",
      "24h_low" : "2200.42",
      "24h_close" : "2231.48",
      "24h_vwap" : "2225.87",
      "24h_volume" : "0.18654724",
      "24h_priceVolume" : "415.22",
      "timestamp" : 1498798060195
    }
..
..
]
```

#### Ticker
Get ticker for a specified asset pair
```
GET /ticker/{AMOUNT_ASSET}/{PRICE_ASSET}

# {AMOUNT_ASSET} and {PRICE_ASSET} are asset IDs or asset Symbols

#Example:
http://localhost:6990/datafeed/ticker/AGATE/BTC
http://localhost:6990/datafeed/ticker/AGATE/8LQW8f7P5d5PZM7GtZEBgaqRPGSzS3DfPuiXrURJ4AJS
```
Response:
```
    {
      "symbol" : "AGATE/BTC",
      "amountAssetID" : "AGATE",
      "amountAssetName" : "AGATE",
      "amountAssetDecimals" : 8,
      "amountAssetTotalSupply" : "100000000.00000000",
      "amountAssetMaxSupply" : "100000000.00000000",
      "amountAssetCirculatingSupply" : "100000000.00000000",
      "priceAssetID" : "8LQW8f7P5d5PZM7GtZEBgaqRPGSzS3DfPuiXrURJ4AJS",
      "priceAssetName" : "WBTC",
      "priceAssetDecimals" : 8,
      "priceAssetTotalSupply" : "21000000.00000000",
      "priceAssetMaxSupply" : "21000000.00000000",
      "priceAssetCirculatingSupply" : "1769.00000000",
      "24h_open" : "0.00167870",
      "24h_high" : "0.00177000",
      "24h_low" : "0.00150001",
      "24h_close" : "0.00154037",
      "24h_vwap" : "0.00159388",
      "24h_volume" : "38772.93226749",
      "24h_priceVolume" : "61.79940128",
      "timestamp" : 1498798083804
    }
```

#### Trades
Get unconfirmed and confirmed trades for a specified asset pair
```
GET /ticker/{AMOUNT_ASSET}/{PRICE_ASSET}/{LIMIT}        # get the last {LIMIT} trades
GET /ticker/{AMOUNT_ASSET}/{PRICE_ASSET}/{FROM}/{TO}    # get trades within the {FROM} / {TO} time range

    # {AMOUNT_ASSET} and {PRICE_ASSET} are asset IDs or asset Symbols
    # valid {LIMIT} values are between 1 and 100
    # {FROM} and {TO} are Unix epoch timestamps in milliseconds

#Example:
http://localhost:6990/datafeed/trades/AGATE/BTC/3
http://localhost:6990/datafeed/trades/AGATE/BTC/1495296000000/1495296280000
```
Response:
```
[
    {
      "timestamp" : 1495296143670,
      "id" : "5esGG7Q8Hzvjajsac486B5N3JsNHrdiMifwzCMqStakK",
      "confirmed" : true,
      "type" : "buy",
      "price" : "0.00077975",
      "amount" : "317.01051775",
      "buyer" : "3P2TcKrVqphRL4VrFnDK59TgKkEyEugcjAd",
      "seller" : "3P2r8iNt6owth5r514C5ACTufJRABXxhpi5",
      "matcher" : "7kPFrHDiGw1rCm7LPszuECwWYL3dMf6iMifLRDJQZMzy"
    }, {
      "timestamp" : 1495296062249,
      "id" : "3HGJCmCQ9QwQaVjF2Bge5wiKsVZzjZP6xq35tkYHzWyq",
      "confirmed" : true,
      "type" : "buy",
      "price" : "0.00079000",
      "amount" : "130.00000000",
      "buyer" : "3P3iQKHYfSkDnCQAB5zBdUfhnWwxEss1NKQ",
      "seller" : "3PP88DWupShvM5jVZTAragjhdeP53qfhmSw",
      "matcher" : "7kPFrHDiGw1rCm7LPszuECwWYL3dMf6iMifLRDJQZMzy"
    }, {
      "timestamp" : 1495296042552,
      "id" : "E4FPRMYP7Ad2Hb3FS58cgtWr1LQpJyXMUwNrLHtYzrQX",
      "confirmed" : true,
      "type" : "sell",
      "price" : "0.00077977",
      "amount" : "82.00000000",
      "buyer" : "3PJFr7vvZVJnhFtexiDZu3HCUR8RjG4c78c",
      "seller" : "3PPnoB3kiMrG6ZEnfmnWBDnTvYcrVTVucSd",
      "matcher" : "7kPFrHDiGw1rCm7LPszuECwWYL3dMf6iMifLRDJQZMzy"
    }
]
```

#### Trades (by address)
Get trades for a specified asset pair and address
```
GET /ticker/{AMOUNT_ASSET}/{PRICE_ASSET}/{ADDRESS}/{LIMIT}

    # {AMOUNT_ASSET} and {PRICE_ASSET} are asset IDs or asset Symbols
    # valid {LIMIT} values are between 1 and 100

#Example:
http://localhost:6990/datafeed/trades/AGATE/BTC/3PCfUovRHpCoGL54UakGBTSDEXTbmYMU3ib/2
```
Response:
```
[
    {
      "timestamp" : 1498536758694,
      "id" : "BwbTgRw8FQkkF2xAqLz7J2rqkiiw5enqZt1exNW3Vqgb",
      "confirmed" : true,
      "type" : "sell",
      "price" : "0.00165618",
      "amount" : "60.00000000",
      "buyer" : "3PCfUovRHpCoGL54UakGBTSDEXTbmYMU3ib",
      "seller" : "3PFkYGpVfdPuUtSwHrqatdWPk1WXLQHaLfa",
      "matcher" : "7kPFrHDiGw1rCm7LPszuECwWYL3dMf6iMifLRDJQZMzy"
    }, {
      "timestamp" : 1498534434123,
      "id" : "4dUvAQcrN1JwoBWBaCLVKfdm8eEYJzzhhJeCwx1Z3SCB",
      "confirmed" : true,
      "type" : "buy",
      "price" : "0.00167384",
      "amount" : "25.76843292",
      "buyer" : "3PCfUovRHpCoGL54UakGBTSDEXTbmYMU3ib",
      "seller" : "3PR8QqY5dkgBhitrkEHDmXU42Kk8eqps2xF",
      "matcher" : "7kPFrHDiGw1rCm7LPszuECwWYL3dMf6iMifLRDJQZMzy"
    }
]
```

#### Candles
Get OHLCV candlestick data for the specified asset pair
```
GET /candles/{AMOUNT_ASSET}/{PRICE_ASSET}/{TIMEFRAME}/{LIMIT}        # get the last {LIMIT} candles
GET /candles/{AMOUNT_ASSET}/{PRICE_ASSET}/{TIMEFRAME}/{FROM}/{TO}    # get candles within the {FROM} / {TO} time range

    # {AMOUNT_ASSET} and {PRICE_ASSET} are asset IDs or asset Symbols
    # {TIMEFRAME} is expressed in minutes; valid timeframes are valid timeframes are 5, 15, 30, 60, 240, 1440 minutes
    # valid {LIMIT} values are between 1 and 100
    # {FROM} and {TO} are Unix epoch timestamps in milliseconds

#Example:
http://localhost:6990/datafeed/ticker/AGATE/BTC/30/5
http://localhost:6990/datafeed/candles/AGATE/BTC/1440/1495238400000/1496102400000
```
Response:
```
[
    {
      "timestamp" : 1498536000000,
      "open" : "0.00170430",
      "high" : "0.00170430",
      "low" : "0.00165618",
      "close" : "0.00165618",
      "vwap" : "0.00168210",
      "volume" : "264.43216559",
      "priceVolume" : "0.44480134",
      "confirmed" : true
    }, {
      "timestamp" : 1498534200000,
      "open" : "0.00167384",
      "high" : "0.00170331",
      "low" : "0.00166789",
      "close" : "0.00166789",
      "vwap" : "0.00169317",
      "volume" : "409.26779823",
      "priceVolume" : "0.69295995",
      "confirmed" : true
    }, {
      "timestamp" : 1498532400000,
      "open" : "0.00166756",
      "high" : "0.00166756",
      "low" : "0.00164021",
      "close" : "0.00166366",
      "vwap" : "0.00165797",
      "volume" : "464.69898252",
      "priceVolume" : "0.77045697",
      "confirmed" : true
    }, {
      "timestamp" : 1498530600000,
      "open" : "0.00168726",
      "high" : "0.00168726",
      "low" : "0.00164658",
      "close" : "0.00166753",
      "vwap" : "0.00166071",
      "volume" : "152.10897130",
      "priceVolume" : "0.25260888",
      "confirmed" : true
    }, {
      "timestamp" : 1498528800000,
      "open" : "0.00169710",
      "high" : "0.00169945",
      "low" : "0.00164072",
      "close" : "0.00166644",
      "vwap" : "0.00167681",
      "volume" : "657.62552303",
      "priceVolume" : "1.10271305",
      "confirmed" : true
    }
]
```



## WebSocket API

#### Keep Alive
A WebSocket session may be terminated after 1 minute of inactivity. In order to keep the connection alive, you can ping the server, for example every 30 seconds.

```
{"op":"ping"}
```
Server response:
```
{
  "op" : "pong"
}
```

#### Subscribing to Unconfirmed Transactions (utx)
Receive notifications of new unconfirmed transactions.
```
{"op":"subscribe utx"}
```
Message on new unconfirmed transaction:
```
{
  "op" : "utx",
  "msg" : {
    "type" : 4,
    "id" : "FZndbWcDBgsZTKixu6tebDG5QwuT2jYNz2MRE359xG33",
    "sender" : "3PPKDQ3G67gekeobR8MENopXytEf6M8WXhs",
    "senderPublicKey" : "ACrdghi6PDpLn158GQ7SNieaHeJEDiDCZmCPshTstUzx",
    "fee" : 10000000,
    "timestamp" : 1498469420523,
    "signature" : "wd2EbwbJBeBSEQaFQLH3APo1kjkoZsGRDjCV5n4HTswVcY3qxXVrvukoJHmdNLmmfVrUuRdzwfrYsyreYDeThdb",
    "recipient" : "3PQ6wCS3zAkDEJtvGntQZbjuLw24kxTqndr",
    "assetId" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
    "amount" : 1,
    "feeAsset" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
    "attachment" : "F5v2mb2C4xPK7CJm9Aa9cfUSA5fT"
  }
}
```

#### Subscribing to Confirmed Transactions (tx)
Receive notifications of new confirmed transactions.
```
{"op":"subscribe tx"}
```
Message on new confirmed transaction:
```
{
  "op" : "tx",
  "msg" : {
    "type" : 7,
    "id" : "7LbB46JkBjZnSMLpqqQeFTFrHG1g5q5oA2Hipu4rAg3g",
    "sender" : "3PJaDyprvekvPXPuAtxrapacuDJopgJRaU3",
    "senderPublicKey" : "7kPFrHDiGw1rCm7LPszuECwWYL3dMf6iMifLRDJQZMzy",
    "fee" : 300000,
    "timestamp" : 1498487656766,
    "signature" : "4SYAtNxudu1hD88UfTEPotpmydnnLAJvcrGzBdWk4GDLjpkFYvcxcPcFqL417Qsy7JWDARW6dnGsN86eDhnLpM3U",
    "order1" : {
      "id" : "3c6f7kqz62ER5wsdKoY5WcqkdSn49sq2zCZjcaARKwmC",
      "senderPublicKey" : "6LpFs4kDxXTkmBLBGu1RekVnTGx6Ko8h2hLxvBCJLPBP",
      "matcherPublicKey" : "7kPFrHDiGw1rCm7LPszuECwWYL3dMf6iMifLRDJQZMzy",
      "assetPair" : {
        "amountAsset" : null,

"priceAsset" : "8LQW8f7P5d5PZM7GtZEBgaqRPGSzS3DfPuiXrURJ4AJS"
      },
      "orderType" : "buy",
      "price" : 170078,
      "amount" : 5402596384,
      "timestamp" : 1498487650413,
      "expiration" : 1498487658382,
      "matcherFee" : 300000,
      "signature" : "5ihmSUCjwXGpjUriWGh7zVkRHwhof5LzK6qWUUXQj6cMeZNkmo56oX2zUBjGovaQL7cUzUqBYj6MCuNJ2yQZuoMA"
    },
    "order2" : {
      "id" : "3eYZ1H32vHayZe2Z6gjyAPPaAxWatDdJskNeKeufGGQQ",
      "senderPublicKey" : "6uj6df78drC82VzgxRUKQNN6BCqoZnYe1EjMnS3ph3bj",
      "matcherPublicKey" : "7kPFrHDiGw1rCm7LPszuECwWYL3dMf6iMifLRDJQZMzy",
      "assetPair" : {
        "amountAsset" : null,
        "priceAsset" : "8LQW8f7P5d5PZM7GtZEBgaqRPGSzS3DfPuiXrURJ4AJS"
      },
      "orderType" : "sell",
      "price" : 162274,
      "amount" : 5400000000,
      "timestamp" : 1498487647148,
      "expiration" : 1498487663041,
      "matcherFee" : 300000,
      "signature" : "58wUfumqX6Xqp7UP4ETAUuoEar97zifJJu98fkSTzpNHEUmG8Jy2Y1PsGvpfgNpTkXRdGCt5oK8hwkGPLnuqWCpF"
    },
    "price" : 162274,
    "amount" : 5400000000,
    "buyMatcherFee" : 299855,
    "sellMatcherFee" : 300000
  }
}
```

#### Subscribing to Blocks
Receive notifications of new blocks.
```
{"op":"subscribe block"}
```
Message on new Block:
```
{
  "op" : "block",
  "msg" : {
    "version" : 2,
    "timestamp" : 1498487405663,
    "reference" : "5mdKD2Xts8aczPWcUTNgUEYaWubjBQsgnCcMnpCLTNRSJCwKXd9pzQEh8np2FadY6PH6bc7KFRpiLTtP9T3r2udX",
    "nxt-consensus" : {
      "base-target" : 69,
      "generation-signature" : "DawQQwSj54VsjSncmHsmQbFPPk7yMXpa2ZPycEtm49he"
    },
    "transactions" : [ {
      "type" : 4,
      "id" : "H9KLrw3waN4HDXN6YPL6QxUUGngUiSrPhQk1ZkK6Vgig",
      "sender" : "3P8SLUYzHV5ay4hry71xRSXm8XBZCpwYTt4",
      "senderPublicKey" : "3Rqnu9UCnF1WyNjwWqeHSHTBk7BAeN1jJBC1MwXS5y68",
      "fee" : 100000,
      "timestamp" : 1498487303927,
      "signature" : "5QdhZmzQ6cgE2w8vtD1szp8LRnL4Cni6ToYgUq7zkTmTmxbQxnDyL6sGjUHXijrvFD1vpKgEdDbGNFQXTpmL5AKX",
      "recipient" : "3PE5ZLLSdrryLZ6TSCJZhimY9HxmQT8m4Ty",
      "assetId" : "4uK8i4ThRGbehENwa6MxyLtxAjAo1Rj9fduborGExarC",
      "amount" : 1174,
      "feeAsset" : null,
      "attachment" : "Dcwh3CEBYJMgCkpzudenjK"
    }, {
      "type" : 4,
      "id" : "2Ha6QB7UcGE61DeNTs9ATXJB4sw3gcwjwoqYR1u5ZB3u",
      "sender" : "3P31zvGdh6ai6JK6zZ18TjYzJsa1B83YPoj",
      "senderPublicKey" : "46t5F1bUxG4mAQUiDyMKDBpWhHChLQSyhnVJ8R5jaLqH",
      "fee" : 100000,
      "timestamp" : 1498487273748,
      "signature" : "ir7UYPrMH4HZLLkaQMbFbZb9V5FEb7vy9r4TrQiViXmEip6zpitndRi8dVWKBTD8mhdtCLAie2agoceQ1hidS4g",
      "recipient" : "3PFHbFrBib6F3wmqJKmeDVuwJB2KxR14Eqy",
      "assetId" : null,
      "amount" : 22214754621,
      "feeAsset" : null,
      "attachment" : ""
    }, {
      "type" : 4,
      "id" : "TP317NT1i1HW9p6SPFE4j2vdSC2o8QEDR9DgTV4vCqJ",
      "sender" : "3PPKDQ3G67gekeobR8MENopXytEf6M8WXhs",
      "senderPublicKey" : "ACrdghi6PDpLn158GQ7SNieaHeJEDiDCZmCPshTstUzx",
      "fee" : 10000000,
      "timestamp" : 1498487395968,
      "signature" : "3wfwMoUgEZ7DqSZYoRKjuBnnj92u3SoquVKTLPierqKiQXXPD63znArXfjH5LF5Y7ERtmgj9zhA1Wb6osKFtPmuu",
      "recipient" : "3PQ6wCS3zAkDEJtvGntQZbjuLw24kxTqndr",
      "assetId" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "amount" : 1,
      "feeAsset" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "attachment" : "GnQQFohQSDtLYuwNf1LnSbhxqhR"
    }, {
      "type" : 4,
      "id" : "CuwEL24oHhjcfPNbJqQB68T9pYpRDr98ACon3hNU4CpQ",
      "sender" : "3PPKDQ3G67gekeobR8MENopXytEf6M8WXhs",
      "senderPublicKey" : "ACrdghi6PDpLn158GQ7SNieaHeJEDiDCZmCPshTstUzx",
      "fee" : 10000000,
      "timestamp" : 1498487380177,
      "signature" : "3F7GXEeP2GRQMnACkcSqw48EuvFQWTHF8d8uACd7PxmvrsvLkwiF9qqox52C5y2xpEKApzmmdoZKay4qj9pNRrHF",
      "recipient" : "3PQ6wCS3zAkDEJtvGntQZbjuLw24kxTqndr",
      "assetId" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "amount" : 1,
      "feeAsset" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "attachment" : "GnQQFohQSDtLYuwNf1LnSbhxqhR"
    }, {
      "type" : 4,
      "id" : "9jvKe8QngV8KuE49rwNpwbNkcLmUMjSg1Z3iZYYozKTp",
      "sender" : "3PPKDQ3G67gekeobR8MENopXytEf6M8WXhs",
      "senderPublicKey" : "ACrdghi6PDpLn158GQ7SNieaHeJEDiDCZmCPshTstUzx",
      "fee" : 10000000,
      "timestamp" : 1498487364430,
      "signature" : "gxieQ7FffQSdoNLzpnDXqAeVf6NE64VWbyfJJnhZF18t2hWL2BxAAsYuyZDQT9h6TzW6CpkbNexmMyJbYscVLkJ",
      "recipient" : "3PQ6wCS3zAkDEJtvGntQZbjuLw24kxTqndr",
      "assetId" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "amount" : 1,
      "feeAsset" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "attachment" : "GnQQFohQSDtLYuwNf1LnSbhxqhR"
    }, {
      "type" : 4,
      "id" : "GzrwgWfbFdSLmUavY555QeTWzswfiUkv65o1jCXuzGCD",
      "sender" : "3PPKDQ3G67gekeobR8MENopXytEf6M8WXhs",
      "senderPublicKey" : "ACrdghi6PDpLn158GQ7SNieaHeJEDiDCZmCPshTstUzx",
      "fee" : 10000000,
      "timestamp" : 1498487348455,
      "signature" : "5tbBvnsSmxMzBs1SD5bnposTk8n1jFEaC5rBjdQy3CPVY2mHUHCyGuNjaixVEXq6CdjzaoJJqZNgZPcaBFQJW6Sm",
      "recipient" : "3PQ6wCS3zAkDEJtvGntQZbjuLw24kxTqndr",
      "assetId" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "amount" : 1,
      "feeAsset" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "attachment" : "GnQQFohQSDtLYuwNf1LnSbhxqhR"
    }, {
      "type" : 4,
      "id" : "Gast8hYtAEVLPGHavXJ4UoAKo7XqubdysYgq7gqbYi4K",
      "sender" : "3PPKDQ3G67gekeobR8MENopXytEf6M8WXhs",
      "senderPublicKey" : "ACrdghi6PDpLn158GQ7SNieaHeJEDiDCZmCPshTstUzx",
      "fee" : 10000000,
      "timestamp" : 1498487332586,
      "signature" : "29Dks8Y4nnmy4APv9WBXHXqRZ1VsoaxuiRwrDiytvCVi3gi9Fwy5Zud4kSS2nE1TtQ5qQKL63ctc6p3Cbm5Xskfk",
      "recipient" : "3PQ6wCS3zAkDEJtvGntQZbjuLw24kxTqndr",
      "assetId" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "amount" : 1,
      "feeAsset" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "attachment" : "2SsKTXApnS6nkDyfoPXRBbtmX7"
    }, {
      "type" : 4,
      "id" : "2EWVcfUorCu9Ve8ktvCbsBQHjNn7JQNow3oNjgDstmBg",
      "sender" : "3PPKDQ3G67gekeobR8MENopXytEf6M8WXhs",
      "senderPublicKey" : "ACrdghi6PDpLn158GQ7SNieaHeJEDiDCZmCPshTstUzx",
      "fee" : 10000000,
      "timestamp" : 1498487316562,
      "signature" : "5xTpxAkjSXFTnzDnwMFRNCtb1FtE9rEtg6cr61Ce8oSV4C6arYFdcipu9UnfHHPf1xJsY8MkSpKtWf1o9VKjwaPU",
      "recipient" : "3PQ6wCS3zAkDEJtvGntQZbjuLw24kxTqndr",
      "assetId" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "amount" : 1,
      "feeAsset" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "attachment" : "FBQx4u6ewheaqVe4rPXposJsJnNu"
    }, {
      "type" : 4,
      "id" : "3xSjb5A2U4GYpxeSgUuK5x7nfadoGpXsukXjgWWLjouc",
      "sender" : "3PPKDQ3G67gekeobR8MENopXytEf6M8WXhs",
      "senderPublicKey" : "ACrdghi6PDpLn158GQ7SNieaHeJEDiDCZmCPshTstUzx",
      "fee" : 10000000,
      "timestamp" : 1498487300592,
      "signature" : "4APhFXcYggJXh192aENLxsY6Ppr3FjrqRPQiVKLhMhHEkwnPWpJnAAxv2q1yhMs28yDvQAxJsTytxgurcgLPYJrv",
      "recipient" : "3PQ6wCS3zAkDEJtvGntQZbjuLw24kxTqndr",
      "assetId" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "amount" : 1,
      "feeAsset" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "attachment" : "FBQx4u6ewheaqVe4rPXposJsJnNu"
    }, {
      "type" : 4,
      "id" : "Az7e73sZ28M4GzbVKT5iciy7aDkJLHzKT3NogoWKSviq",
      "sender" : "3PPKDQ3G67gekeobR8MENopXytEf6M8WXhs",
      "senderPublicKey" : "ACrdghi6PDpLn158GQ7SNieaHeJEDiDCZmCPshTstUzx",
      "fee" : 10000000,
      "timestamp" : 1498487284688,
      "signature" : "7oU6RxuUcjNKaX3H1jKRH26uQBetEWNgPvS4w1F4AS841a9ojKfgpKyqQeZEtZVTnXbAM2PV6pZNgGdL5uRLR1q",
      "recipient" : "3PQ6wCS3zAkDEJtvGntQZbjuLw24kxTqndr",
      "assetId" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "amount" : 1,
      "feeAsset" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "attachment" : "FBQx4u6ewheaqVe4rPXposJsJnNu"
    }, {
      "type" : 4,
      "id" : "53t9nGV7KUhWq6RuU9UTGakCd2jF2hAuG1JrpD2gBfvv",
      "sender" : "3PPKDQ3G67gekeobR8MENopXytEf6M8WXhs",
      "senderPublicKey" : "ACrdghi6PDpLn158GQ7SNieaHeJEDiDCZmCPshTstUzx",
      "fee" : 10000000,
      "timestamp" : 1498487268813,
      "signature" : "3hzNc5gTZJjxy9BXXvpFUDbRNC44wCckNc7eR3zFLwCrARBd13ahr2zVLaz2ZcX5TiDcyURYxm1twgQT5zCZZhZB",
      "recipient" : "3PQ6wCS3zAkDEJtvGntQZbjuLw24kxTqndr",
      "assetId" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "amount" : 1,
      "feeAsset" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "attachment" : "FEawwsk8L93o6RX7BWbqBh7gkbeZ"
    }, {
      "type" : 4,
      "id" : "BerdQQo4Zd68shQpL8HjzXQPwy19em9CyP9Cdqt5xiCm",
      "sender" : "3PPKDQ3G67gekeobR8MENopXytEf6M8WXhs",
      "senderPublicKey" : "ACrdghi6PDpLn158GQ7SNieaHeJEDiDCZmCPshTstUzx",
      "fee" : 10000000,
      "timestamp" : 1498487253010,
      "signature" : "5MM6pFMfkX7Z8h1PggyMPcJsztrFdoDn6SRVrXN8SNT8iAJa9KkUMyNsgJYaz5CDyFPda2AhyT24qzy4hUKfSpmm",
      "recipient" : "3PQ6wCS3zAkDEJtvGntQZbjuLw24kxTqndr",
      "assetId" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "amount" : 1,
      "feeAsset" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "attachment" : "FEawwsk8L93o6RX7BWbqBh7gkbeZ"
    }, {
      "type" : 4,
      "id" : "FrmkiBikKRUHbj1Dtt2G9NtF4oSmJo2TDK8hYmtDTGTY",
      "sender" : "3PPKDQ3G67gekeobR8MENopXytEf6M8WXhs",
      "senderPublicKey" : "ACrdghi6PDpLn158GQ7SNieaHeJEDiDCZmCPshTstUzx",
      "fee" : 10000000,
      "timestamp" : 1498487236975,
      "signature" : "vThcrmfWzKZNkErmGjSxAyfK9ytY4RzdJHhgRvEgx21PbPkfFRz9XnLxQBATLZHueR1NBcXbP59DJv9CjBqqwao",
      "recipient" : "3PQ6wCS3zAkDEJtvGntQZbjuLw24kxTqndr",
      "assetId" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "amount" : 1,
      "feeAsset" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
      "attachment" : "FEawwsk8L93o6RX7BWbqBh7gkbeZ"
    } ],
    "generator" : "3PFrn8EHRhjJGEQxYwWKdJcwcsW1XFRJbmz",
    "signature" : "4ZfdWGUq4LcntWYmb1YKiQCUiRjbeY882ihXaVq66DeGavP7XZrcWoi4BTdwAZ1NaFY4d8LRQaqYhV5u4u1bTzkK",
    "fee" : 110200000,
    "blocksize" : 3223,
    "height" : 555384
  }
}
```

#### Subscribing to an Address
Receive notifications of new unconfirmed or confirmed transactions involving the specified address.
```
{"op":"subscribe address/{ADDRESS}"}            # subscribe to {ADDRESS}
{"op":"subscribe address/{ADDRESS}/utx"}        # subscribe to {ADDRESS} (only unconfirmed txs)
{"op":"subscribe address/{ADDRESS}/tx"}         # subscribe to {ADDRESS} (only confirmed txs)

#Example:
{"op":"subscribe address/3P31zvGdh6ai6JK6zZ18TjYzJsa1B83YPoj"}
```
Message on new transaction:
```
{
  "op" : "address/3P31zvGdh6ai6JK6zZ18TjYzJsa1B83YPoj/tx",
  "msg" : {
    "type" : 4,
    "id" : "A5ThoBPBzef413tTZJ5ZFcjQp43uk3Zt5kFgbWvxz15o",
    "sender" : "3P31zvGdh6ai6JK6zZ18TjYzJsa1B83YPoj",
    "senderPublicKey" : "46t5F1bUxG4mAQUiDyMKDBpWhHChLQSyhnVJ8R5jaLqH",
    "fee" : 100000,
    "timestamp" : 1498482309836,
    "signature" : "5i1EdNTtZbAUjS9aLb7uJsnn48XC1UKi13tWjbW3sP7Dui1JfxgutgiPnGcgyw6FzQibjnTQd9NMUrgWEVKznRZL",
    "recipient" : "3P4GE5kPLDi3YgDUvPnueGq1S6NMV5gknMb",
    "assetId" : null,
    "amount" : 892509874,
    "feeAsset" : null,
    "attachment" : ""
  }
}
```

#### Subscribing to Balance changes
Receive notifications of balance changes for the specified address (or for any address).
```
{"op":"subscribe balance/{ADDRESS}"}        # subscribe to balance changes for {ADDRESS}
{"op":"subscribe balance"}                  # subscribe to balance changes for any address

#Example:
{"op":"subscribe balance/3P31zvGdh6ai6JK6zZ18TjYzJsa1B83YPoj"}
```
Message on balance change:
```
{
  "op" : "balance/3P31zvGdh6ai6JK6zZ18TjYzJsa1B83YPoj",
  "msg" : {
    "AGATE" : 1264213718872765,
    "28rURQX5YKKVtdg1NBkMZN4iaXMVMr4YUnH3pvQZttzW" : 1,
    "2aNMjB9fe7mKqiG9zws8KvRLLQuKZb3o7vuGixuzwPFX" : 10000,
    "3wqMtvbLgCAHaStSNEoqYRVp1vrrJoaP41DdC5Mfe98L" : 6948,
    "4eWBPyY4XNPsFLoQK3iuVUfamqKLDu5o6zQCYyp9d8Ae" : 1000,
    "4rmhfoscYcjz1imNDvtz45doouvrQqDpbX7xdfLB4guF" : 7,
    "4vV2ZSC8hzADa8Ed4f6mUuSCkreJrCCRksc6NaXhmiYW" : 1000000,
    "5DmkDK1e5j7oGwzZqy1gFwVUsXYskvRLwMYUdVSirSHb" : 162,
    "89C2F79559Hg6bS1Lnxja82BRjW62XHjyC2ihsqCUj4u" : 100000000,
    "8LQW8f7P5d5PZM7GtZEBgaqRPGSzS3DfPuiXrURJ4AJS" : 37417000,
    "8UGsTQJZHgmn3k7TxrPZ8xYokJF9x69xBMD1QjYqFzVh" : 1,
    "8Yiktau4mPvqBZpWJyCVm6D93jtzB2XVDiEvbzMffFzi" : 1000,
    "8juYABzCQpA84eroW3WDKzBzNCpNsXihFssqPyWqKjH2" : 25000000000,
    "8ofu3VpEaVCFjRqLLqzTMNs5URKUUQMrPp3k6oFmiCc6" : 18920097320,
    "9cydYWFAG278V7FaMG1jiECdCYetvMzW4BL2fVKSNyw" : 1,
    "A8NnpikFDyTpWXhsvwRij76BcbcQ3mRmEPTDusNEDJd9" : 2,
    "AnERqFRffNVrCbviXbDEdzrU6ipXCP5Y1PKpFdRnyQAy" : 4938300000000,
    "AzATZpdYT2y9vXEiB8MbojpHDgp5wtvmtGurNHWsDqwS" : 5000000000000,
    "BDMRyZsmDZpgKhdM7fUTknKcUbVVkDpMcqEj31PUzjMy" : 50798248742533,
    "BhHxVxCfjXijwGet6bdwio34mMUFeqJC8iiAcYdV3Mec" : 1000000000000,
    "C6SsECGzJfqQex6PyFQ4Jt2t7jWUQY92zMaPgveJs2oP" : 10000000000,
    "CAyBTqxngcwR4X1cyhcZBTwEhrmFAPu7A4jdx1Eiq6pp" : 1000000000,
    "CaDS3qrR8GsHfQ5XrTCssn8NdRMdCHNgkAtGDaMRkJ5y" : 2,
    "Ck3G6iRDbDYkeCUMxUeWiBkgeRHwPdHdyXMPWuCZ3JLE" : 20000,
    "DHgwrRvVyqJsepd32YbBqUeDH4GJ1N984X8QoekjgH8J" : 15856,
    "DxG3PLganyNzajHGzvWLjc4P3T2CpkBGxY4J9eJAAUPw" : 200000000000000,
    "E4ip4jzTc4PCvebYn1818T4LNoYBVL3Y4Y4dMPatGwa9" : 500000000000,
    "EeLMX9YyjMNr1gEkZm96Tow9niQezWUVXFWSgWhjFbQs" : 1000000000,
    "EsNuaQKWhHxjzJzQVAgky4VXdyYDfmocmED8f1yLensP" : 1000100000000,
    "FLbGXzrpqkvucZqsHDcNxePTkh2ChmEi4GdBfDRRJVof" : 791530900165201,
    "Ftim86CXM6hANxArJXZs2Fq7XLs3nJvgBzzEwQWwQn6N" : 2117290600000000,
    "FzDS7qLsZgVmzJub3yJubvBvyXd6ZJw8HrPiuDZA9CQY" : 1,
    "G6F52cNqSi7v2kuj2anzyKkYgbhsijWvCJDD3WvKzjLH" : 100000000,
    "GQr2fpkfmWjMaZCbqMxefbiwgvpcNgYdev7xpuX6xqcE" : 1000,
    "GaqqYPtdrgkTjijWB4sB876cvLL6txd7564RorF9Tjoq" : 50000000000,
    "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj" : 1250100006544,
    "J1cNEwbVLfn3skMzDZmpujXUgLDyNh2D5nDq8fbvDwKy" : 1000000000,
    "J3m2Z4PJ5FuQf6kYFr6LocsQFu9Dc7FYsPdNgsweUqQW" : 100000000000,
    "RRBqh2XxcwAdLYEdSickM589Vb4RCemBCPH5mJaWhU9" : 4938300000000,
    "fQkfbgHdvwnfauSfg8a19ACLWKNnLjykAiQVHgMA76R" : 1981800019818
  }
}
```

#### Subscribing to an Asset
Receive notifications of new unconfirmed or confirmed transactions involving the specified asset.
```
{"op":"subscribe asset/{ASSET_ID}"}            # subscribe to {ASSET_ID}
{"op":"subscribe asset/{ASSET_ID}/utx"}        # subscribe to {ASSET_ID} (only unconfirmed txs)
{"op":"subscribe asset/{ASSET_ID}/tx"}         # subscribe to {ASSET_ID} (only confirmed txs)

#Example:
{"op":"subscribe asset/HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj"}
```
Message on new transaction:
```
{
  "op" : "asset/HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj/tx",
  "msg" : {
    "type" : 4,
    "id" : "BuDfwWgqcsumWyzWxia399SMfTcAAVZzhvMJk3Z39Hu3",
    "sender" : "3PPKDQ3G67gekeobR8MENopXytEf6M8WXhs",
    "senderPublicKey" : "ACrdghi6PDpLn158GQ7SNieaHeJEDiDCZmCPshTstUzx",
    "fee" : 10000000,
    "timestamp" : 1498482230818,
    "signature" : "5nTQMKVYVsWakPSVJshEQKCvxcxPxvvJcQZnfuxfzH4nu6St6yCEWmXz2biteQvMnPTu17t3Am1ghy6QLsDgQJAD",
    "recipient" : "3PQ6wCS3zAkDEJtvGntQZbjuLw24kxTqndr",
    "assetId" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
    "amount" : 1,
    "feeAsset" : "HzfaJp8YQWLvQG4FkUxq2Q7iYWMYQ2k8UF89vVJAjWPj",
    "attachment" : "EychFwTnCg7tuWisqZprfAmwtSD7"
  }
}
```

#### Subscribing to Trades
Receive notifications of new confirmed or unconfirmed trades for the specified asset pair (or for any pair).
```
{"op":"subscribe trades/{AMOUNT_ASSET}/{PRICE_ASSET}"}        # subscribe to trades for the {AMOUNT_ASSET}/{PRICE_ASSET} pair
{"op":"subscribe trades"}                                     # subscribe to all trades

#Example:
{"op":"subscribe trades/AGATE/8LQW8f7P5d5PZM7GtZEBgaqRPGSzS3DfPuiXrURJ4AJS"}
```
Message on new trade:
```
{
  "op" : "trades/AGATE/8LQW8f7P5d5PZM7GtZEBgaqRPGSzS3DfPuiXrURJ4AJS",
  "msg" : {
    "timestamp" : 1498481625760,
    "id" : "88zw8u1thmyGEm4pRKCXxCkfbMexBeUhCFYTHsJRSxMv",
    "confirmed" : true,
    "type" : "buy",
    "price" : 162799,
    "amount" : 29580000000,
    "buyer" : "3P2EKcmNT9mU32X8iFmxd9k2Hu7xPh5ijVx",
    "seller" : "3PAsPz3V3PDJET2MK5QKimLgRLRCyB5Np9S",
    "matcher" : "7kPFrHDiGw1rCm7LPszuECwWYL3dMf6iMifLRDJQZMzy"
  }
}
```

#### Unsubscribing
Stop receiving notifications from a subscribed channel or from all channels
```
{"op":"unsubscribe {CHANNEL}"}        # unsubscribe from the specified channel
{"op":"unsubscribe all"}              # unsubscribe from all channels

#Example:
{"op":"unsubscribe utx"}
```
Server response:
```
{
  "status" : "ok",
  "op" : "unsubscribe utx"
}
```
