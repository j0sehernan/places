package com.tyba.places.entities

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.tyba.places.constants.DatePatterns
import com.tyba.places.constants.Fields
import com.tyba.places.constants.Tables
import org.springframework.data.annotation.CreatedDate
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = Tables.TRANSACTIONS)
class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null,

    @Column(nullable = false)
    var username: String = "",

    @Column(nullable = false)
    val action: String = "",

    @JsonProperty(Fields.CREATED_AT)
    @Column(name = Fields.CREATED_AT, nullable = false, updatable = false)
    @DateTimeFormat(pattern = DatePatterns.DEFAULT)
    @JsonFormat(pattern = DatePatterns.DEFAULT)
    @CreatedDate
    val createdAt: LocalDateTime? = LocalDateTime.now()
)