package com.tyba.places.entities

import com.fasterxml.jackson.annotation.JsonProperty
import com.tyba.places.constants.Fields
import com.tyba.places.constants.Tables
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = Tables.USERS)
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,

    @JsonProperty(Fields.FIRST_NAME)
    @Column(name = Fields.FIRST_NAME, nullable = false)
    val firstName: String = "",

    @JsonProperty(Fields.LAST_NAME)
    @Column(name = Fields.LAST_NAME, nullable = false)
    val lastName: String = "",

    @Column(nullable = false, unique = true)
    val email: String = "",

    @Column(nullable = false)
    var password: String = ""
)