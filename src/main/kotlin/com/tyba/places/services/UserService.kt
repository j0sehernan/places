package com.tyba.places.services

import com.tyba.places.constants.Actions
import com.tyba.places.constants.Roles
import com.tyba.places.entities.Transaction
import com.tyba.places.entities.User
import com.tyba.places.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService: UserDetailsService {
    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var transactionService: TransactionService

    @Autowired
    private lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder

    fun list(): List<User> {
        transactionService.create(Transaction(action = Actions.LIST_USER))

        return userRepository.findAll()
    }

    fun create(user: User): User {
        user.id = null
        user.password = bCryptPasswordEncoder.encode(user.password)

        return userRepository.save(user)
    }

    @Override
    override fun loadUserByUsername(email: String): UserDetails {
        val user = userRepository.findByEmail(email)

        val roles = mutableListOf<GrantedAuthority>()
        roles.add(SimpleGrantedAuthority(Roles.ADMIN))

        return org.springframework.security.core.userdetails.User(user.email, user.password, roles)
    }
}