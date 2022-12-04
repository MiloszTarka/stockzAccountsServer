package com.stockz.stockzaccountsserver.services

import com.stockz.stockzaccountsserver.Repository.WalletRepository

interface WalletInterface {
    fun subtractStock(walletRepository: WalletRepository,
                      userid : String,
                      symbol : String,
                      amount : String)
    fun addStock(walletRepository: WalletRepository,
                 userid : String,
                 symbol : String,
                 amount : String)
}