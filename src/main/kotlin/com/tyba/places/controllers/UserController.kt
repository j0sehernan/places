package com.tyba.places.controllers

import com.tyba.places.constants.Routes
import com.tyba.places.entities.User
import com.tyba.places.services.UserService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [Routes.USERS], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
class UserController(private val userService: UserService) {
    /**
     * List of Users
     *
     * @return List<User>
     */
    @GetMapping
    fun list(): List<User> {
        return userService.list()
    }

    /**
     * Create a user
     *
     * @return User Created
     */
    @PostMapping
    fun create(@RequestBody user: User): User {
        return userService.create(user)
    }
}