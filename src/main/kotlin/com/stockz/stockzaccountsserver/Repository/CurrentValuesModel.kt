package com.stockz.stockzaccountsserver.Repository

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("CurrentValues")
class CurrentValuesModel {
    @Id
    lateinit var id: String
    var AAPL : Double = 0.0
    var AMZN : Double = 0.0
    var BABA : Double = 0.0
    var BRKA : Double = 0.0
    var BRKB : Double = 0.0
    var CHT : Double = 0.0
    var GOOG : Double = 0.0
    var GOOGL : Double = 0.0
    var JNJ : Double = 0.0
    var JPM : Double = 0.0
    var MA : Double = 0.0
    var META : Double = 0.0
    var MSFT : Double = 0.0
    var PG : Double = 0.0
    var RHHBF : Double = 0.0
    var RHHVF : Double = 0.0
    var TSM : Double = 0.0
    var V : Double = 0.0
    var VOD : Double = 0.0
    var WMT : Double = 0.0

    fun CurrentValuesModel(id: String,
                  AAPL : Double,
                  AMZN : Double,
                  BABA : Double,
                  BRKA : Double,
                  BRKB : Double,
                  CHT : Double,
                  GOOG : Double,
                  GOOGL : Double,
                  JNJ : Double,
                  JPM : Double,
                  MA : Double,
                  META : Double,
                  MSFT : Double,
                  PG : Double,
                  RHHBF : Double,
                  RHHVF : Double,
                  TSM : Double,
                  V : Double,
                  VOD : Double,
                  WMT : Double) {
        this.id = id
        this.AAPL = AAPL
        this.AMZN = AMZN
        this.BABA = BABA
        this.BRKA = BRKA
        this.BRKB = BRKB
        this.CHT = CHT
        this.GOOG = GOOG
        this.GOOGL = GOOGL
        this.JNJ = JNJ
        this.JPM = JPM
        this.MA = MA
        this.META = META
        this.MSFT = MSFT
        this.PG = PG
        this.RHHBF = RHHBF
        this.RHHVF = RHHVF
        this.TSM = TSM
        this.V = V
        this.VOD = VOD
        this.WMT = WMT
    }
}