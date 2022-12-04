package com.stockz.stockzaccountsserver.services

import com.stockz.stockzaccountsserver.Repository.StockEntity
import com.stockz.stockzaccountsserver.Repository.WalletRepository
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
@Scope("session")
@Service
object WalletService : WalletInterface {
    override fun subtractStock(walletRepository: WalletRepository, userid: String, symbol: String, amount: String) {
        var userPortfolio = walletRepository.getWalletModelByUserId(userid)
        var wallet = userPortfolio.Wallet

        var requestedStock = wallet.filter {
                stock -> stock.Symbol.equals(symbol.uppercase())
        }

        if(!requestedStock.isEmpty()){
            run breaking@{
                wallet.forEach {
                    if(it.Symbol.equals(symbol.uppercase())) {
                        it.Amount = (it.Amount.toDouble() - amount.toDouble()).toString()
                    }
                    if(it.Amount.equals("0.0")) {
                        return@breaking wallet.remove(it)
                    }
                }
            }
        }

        walletRepository.save(userPortfolio)
    }

    override fun addStock(walletRepository: WalletRepository, userid: String, symbol: String, amount: String) {
        var userPortfolio = walletRepository.getWalletModelByUserId(userid)
        var wallet = userPortfolio.Wallet

        var requestedStock = wallet.filter {
                stock -> stock.Symbol.equals(symbol.uppercase())
        }

        if(!requestedStock.isEmpty()){
            wallet.forEach {
                if(it.Symbol.equals(symbol.uppercase())){
                    it.Amount = (it.Amount.toDouble() + amount.toDouble()).toString()
                }
            }
        } else {
            var newStock = StockEntity()
            newStock.StockEntity(symbol.uppercase(), amount)
            wallet.add(newStock)
        }

        walletRepository.save(userPortfolio)
    }
}