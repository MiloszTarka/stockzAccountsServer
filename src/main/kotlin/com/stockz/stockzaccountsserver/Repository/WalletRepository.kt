package com.stockz.stockzaccountsserver.Repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface WalletRepository : MongoRepository<WalletModel, String> {

    @Query("{UserId :?0}")
    fun getWalletModelByUserId(UserId : String) : WalletModel

    override fun count(): Long

}