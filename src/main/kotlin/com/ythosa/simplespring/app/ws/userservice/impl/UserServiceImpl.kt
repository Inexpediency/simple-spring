package com.ythosa.simplespring.app.ws.userservice.impl

import com.ythosa.simplespring.app.ws.exceptions.UserNotFoundException
import com.ythosa.simplespring.app.ws.shared.Utils
import com.ythosa.simplespring.app.ws.ui.model.request.UpdateUserDetailsRequestModel
import com.ythosa.simplespring.app.ws.ui.model.request.UserDetailsRequestModel
import com.ythosa.simplespring.app.ws.ui.model.response.UserRest
import com.ythosa.simplespring.app.ws.userservice.UserService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(val utils: Utils) : UserService {
    private val users = mutableMapOf<String, UserRest>()
    override fun getUsers(): List<UserRest> {
        return users.toList().map { it.second }
    }

    override fun getUserById(userId: String): UserRest {
        return users[userId] ?: throw UserNotFoundException()
    }

    override fun createUser(userDetails: UserDetailsRequestModel): UserRest {
        val userId = this.utils.generateUUID()
        val user = UserRest.Builder()
            .userId(userId)
            .firstName(userDetails.firstName!!)
            .lastName(userDetails.lastName!!)
            .email(userDetails.email!!)
            .password(userDetails.password!!)
            .build()

        users[userId] = user

        return user
    }

    override fun updateUser(userId: String, userDetails: UpdateUserDetailsRequestModel): UserRest {
        val user = users[userId] ?: throw UserNotFoundException()

        val updatedUser = UserRest.Builder()
            .userId(userId)
            .firstName(userDetails.firstName ?: user.firstName!!)
            .lastName(userDetails.lastName ?: user.lastName!!)
            .email(user.email!!)
            .password(user.password!!)
            .build()

        users[userId] = updatedUser

        return updatedUser
    }

    override fun deleteUser(userId: String) {
        users[userId] ?: throw UserNotFoundException()

        users.remove(userId)
    }
}