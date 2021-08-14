package com.ythosa.simplespring.app.ws.ui.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UserController {

    @GetMapping
    fun getUser(): String {
        return "get user was called"
    }

    @PostMapping
    fun createUser(): String {
        return "create user was called"
    }

    @PutMapping
    fun updateUser(): String {
        return "update user was called"
    }

    @DeleteMapping
    fun deleteUser(): String {
        return "delete user was called"
    }
}
