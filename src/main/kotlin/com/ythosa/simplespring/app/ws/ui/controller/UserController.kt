package com.ythosa.simplespring.app.ws.ui.controller

import com.ythosa.simplespring.app.ws.ui.model.response.UserRest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UserController {

    @GetMapping
    fun getUsers(
        @RequestParam(value = "page", defaultValue = "1") page: Int,
        @RequestParam(value = "limit") limit: Int,
        @RequestParam(value = "sort", required = false) sort: String?
    ): String {
        return "get users was called with page=$page and limit=$limit and sort=${sort ?: "nope"}"
    }

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: String): UserRest {
        return UserRest.Builder()
            .firstName("Ruslan")
            .lastName("Babin")
            .email("vasus714@yandex.ru")
            .userId(userId)
            .build()
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
