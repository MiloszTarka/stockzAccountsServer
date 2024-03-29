package com.stockz.stockzaccountsserver


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class StockzAccountsServerApplication

fun main(args: Array<String>) {
    runApplication<StockzAccountsServerApplication>(*args, )
}
