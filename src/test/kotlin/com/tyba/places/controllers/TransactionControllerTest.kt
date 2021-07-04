package com.tyba.places.controllers

import com.tyba.places.controllers.TransactionController
import com.tyba.places.entities.Transaction
import com.tyba.places.services.TransactionService
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@RunWith(MockitoJUnitRunner::class)
@SpringBootTest
class TransactionControllerTest {
    @Mock
    private lateinit var transactionService: TransactionService

    @InjectMocks
    private lateinit var transactionController: TransactionController

    @Test
    fun testList() {
        val transactions = listOf(Transaction(id=1, username = "Gael", action = "test", createdAt = LocalDateTime.now()))
        Mockito.`when`(transactionService.list()).thenReturn(transactions)

        val response = transactionController.list()

        Assert.assertEquals(1, response.size)
    }
}