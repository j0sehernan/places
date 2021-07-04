package com.tyba.places.controllers

import com.tyba.places.constants.Routes
import com.tyba.places.entities.Transaction
import com.tyba.places.services.TransactionService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [Routes.TRANSACTIONS], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
class TransactionController(private val transactionService: TransactionService) {
    /**
     * List records of Transactions
     *
     * @return List<Transaction>
     */
    @GetMapping
    fun list(): List<Transaction> {
        return transactionService.list()
    }
}