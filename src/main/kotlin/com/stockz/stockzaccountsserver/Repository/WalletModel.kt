package com.stockz.stockzaccountsserver.Repository

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("Wallets")
class WalletModel {
    @Id
    lateinit var id: String

    lateinit var UserId : String

    lateinit var Wallet : MutableList<StockEntity>

    fun WalletModel(id: String, UserId: String, Wallet : MutableList<StockEntity>) {
        this.id = id
        this.UserId = UserId
        this.Wallet = Wallet
    }
}

class StockEntity {
    lateinit var Symbol : String
    lateinit var Amount : String

    fun StockEntity(Symbol: String, Amount: String) {
        this.Symbol = Symbol
        this.Amount = Amount
    }
}