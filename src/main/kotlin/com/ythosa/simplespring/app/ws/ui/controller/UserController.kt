package com.ythosa.simplespring.app.ws.ui.controller

import com.ythosa.simplespring.app.ws.ui.model.request.UpdateUserDetailsRequestModel
import com.ythosa.simplespring.app.ws.ui.model.request.UserDetailsRequestModel
import com.ythosa.simplespring.app.ws.ui.model.response.UserRest
import com.ythosa.simplespring.app.ws.userservice.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("users")
class UserController(val userService: UserService) {
    @GetMapping
    fun getUsers(
        @RequestParam(value = "page", defaultValue = "1") page: Int,
        @RequestParam(value = "limit") limit: Int,
        @RequestParam(value = "sort", required = false) sort: String?
    ): List<UserRest> {
        return userService.getUsers()
    }

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: String): ResponseEntity<UserRest> {
        return ResponseEntity<UserRest>(userService.getUserById(userId), HttpStatus.OK)
    }

    @PostMapping
    fun createUser(@Valid @RequestBody request: UserDetailsRequestModel): UserRest {
        return userService.createUser(request)
    }

    @PutMapping("/{userId}")
    fun updateUser(
        @PathVariable userId: String,
        @Valid @RequestBody request: UpdateUserDetailsRequestModel
    ): UserRest {
        return userService.updateUser(userId, request)
    }

    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: String): ResponseEntity<Void> {
        userService.deleteUser(userId)

        return ResponseEntity.ok().build()
    }
}
