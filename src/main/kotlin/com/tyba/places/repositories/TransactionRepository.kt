package com.tyba.places.repositories

import com.tyba.places.entities.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository : JpaRepository<Transaction, Long> {
    fun findByOrderByCreatedAtDesc(): List<Transaction>
}