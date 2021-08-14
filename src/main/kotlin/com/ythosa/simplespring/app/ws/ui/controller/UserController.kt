package com.ythosa.simplespring.app.ws.ui.controller

import com.ythosa.simplespring.app.ws.ui.model.request.UserDetailsRequestModel
import com.ythosa.simplespring.app.ws.ui.model.response.UserRest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

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
    fun getUser(@PathVariable userId: String): ResponseEntity<UserRest> {
        val response = UserRest.Builder()
            .firstName("Ruslan")
            .lastName("Babin")
            .email("vasus714@yandex.ru")
            .build()

        return ResponseEntity<UserRest>(response, HttpStatus.OK)
    }

    @PostMapping
    fun createUser(@Valid @RequestBody request: UserDetailsRequestModel): UserRest {
        return UserRest.Builder()
            .firstName("Ruslan")
            .lastName("Babin")
            .email("vasus714@yandex.ru")
            .build()
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
