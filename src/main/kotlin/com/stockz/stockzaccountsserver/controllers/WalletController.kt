package com.stockz.stockzaccountsserver.controllers

import com.stockz.stockzaccountsserver.Repository.CurrentValuesRepository
import com.stockz.stockzaccountsserver.Repository.WalletRepository
import com.stockz.stockzaccountsserver.services.WalletService
import org.json.JSONArray
import org.json.JSONObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Scope
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@Scope("request")
class WalletController(val walletRepository: WalletRepository,
                       val currentValuesRepository: CurrentValuesRepository,
                       val service : WalletService) {

    var MULTIPLIER_ID = "6383c51cfd118b9e979ffa9e"
    val logger: Logger = LoggerFactory.getLogger(WalletController::class.java)

    @GetMapping(value=["/wallet"])
    fun getWallet(@RequestParam userid : String): String {
        logger.info("Requested wallet of user" + userid)
        return JSONArray(walletRepository.getWalletModelByUserId(userid).Wallet).toString()
    }

    @GetMapping(value=["/addstock"])
    fun addStockToWallet(@RequestParam userid : String,
                         @RequestParam symbol : String,
                         @RequestParam amount : String): String {
        logger.info("Requested wallet of user" + userid)
        service.addStock(walletRepository, userid, symbol,amount)
        return JSONArray(walletRepository.getWalletModelByUserId(userid).Wallet).toString()

    }

    @GetMapping(value=["/subtractstock"])
    fun subtractStockFromWallet(@RequestParam userid : String,
                         @RequestParam symbol : String,
                         @RequestParam amount : String): String {
        logger.info("Requested wallet of user" + userid)
        service.subtractStock(walletRepository, userid, symbol,amount)
        return JSONArray(walletRepository.getWalletModelByUserId(userid).Wallet).toString()

    }
    @GetMapping(value=["/multipliers"])
    fun getCurrentValues() : String {
        logger.info("Requested current values")
        return JSONObject(currentValuesRepository.findById(MULTIPLIER_ID).get()).toString()
    }
}