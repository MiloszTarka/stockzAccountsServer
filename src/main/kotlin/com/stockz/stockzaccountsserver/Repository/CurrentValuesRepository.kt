package com.stockz.stockzaccountsserver.Repository

import org.springframework.data.mongodb.repository.MongoRepository

interface CurrentValuesRepository : MongoRepository<CurrentValuesModel, String> {
    override fun count(): Long
}