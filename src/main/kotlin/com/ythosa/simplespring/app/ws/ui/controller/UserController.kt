package com.ythosa.simplespring.app.ws.ui.controller

import com.ythosa.simplespring.app.ws.ui.model.request.UpdateUserDetailsRequestModel
import com.ythosa.simplespring.app.ws.ui.model.request.UserDetailsRequestModel
import com.ythosa.simplespring.app.ws.ui.model.response.UserRest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("users")
class UserController {
    private val users = mutableMapOf<String, UserRest>()

    @GetMapping
    fun getUsers(
        @RequestParam(value = "page", defaultValue = "1") page: Int,
        @RequestParam(value = "limit") limit: Int,
        @RequestParam(value = "sort", required = false) sort: String?
    ): List<UserRest> {
        return users.toList().map { it.second }
    }

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: String): ResponseEntity<UserRest> {
        users[userId] ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "user not found")

        return ResponseEntity<UserRest>(users[userId], HttpStatus.OK)
    }

    @PostMapping
    fun createUser(@Valid @RequestBody request: UserDetailsRequestModel): UserRest {
        val userId = UUID.randomUUID().toString()
        val user = UserRest.Builder()
            .userId(userId)
            .firstName(request.firstName!!)
            .lastName(request.lastName!!)
            .email(request.email!!)
            .password(request.password!!)
            .build()

        users[userId] = user

        return user
    }

    @PutMapping("/{userId}")
    fun updateUser(
        @PathVariable userId: String,
        @Valid @RequestBody request: UpdateUserDetailsRequestModel
    ): UserRest {
        val user = users[userId] ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "user not found")

        val updatedUser = UserRest.Builder()
            .userId(userId)
            .firstName(request.firstName ?: user.firstName!!)
            .lastName(request.lastName ?: user.lastName!!)
            .email(user.email!!)
            .password(user.password!!)
            .build()

        users[userId] = updatedUser

        return updatedUser
    }

    @DeleteMapping
    fun deleteUser(): String {
        return "delete user was called"
    }
}
