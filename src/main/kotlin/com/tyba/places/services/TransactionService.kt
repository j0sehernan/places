package com.tyba.places.services

import com.tyba.places.entities.Transaction
import com.tyba.places.repositories.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Service

@Service
class TransactionService {
    @Autowired
    private lateinit var transactionRepository: TransactionRepository

    fun list(): List<Transaction> {
        return transactionRepository.findByOrderByCreatedAtDesc()
    }

    fun create(transaction: Transaction): Transaction {
        val user = SecurityContextHolder.getContext().authentication.principal as User
        transaction.username =  user.username

        return transactionRepository.save(transaction)
    }
}