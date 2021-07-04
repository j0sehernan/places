package com.tyba.places.services

import com.tyba.places.entities.Transaction
import com.tyba.places.repositories.TransactionRepository
import org.junit.Assert
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.boot.test.context.SpringBootTest
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import java.time.LocalDateTime
import org.junit.jupiter.api.Test

@RunWith(MockitoJUnitRunner::class)
@SpringBootTest
internal class TransactionServiceTest {
    @Mock
    private lateinit var transactionRepository: TransactionRepository

    @InjectMocks
    private lateinit var transactionService: TransactionService

    @Test
    fun testList() {
        val transactions = listOf(Transaction(id=1,username = "Gael",action = "test", createdAt = LocalDateTime.now()))
        Mockito.`when`(transactionRepository.findByOrderByCreatedAtDesc()).thenReturn(transactions)

        val response = transactionService.list()

        Assert.assertEquals(1, response.size)
    }
}