package com.ythosa.simplespring.app.ws.userservice

import com.ythosa.simplespring.app.ws.ui.model.request.UpdateUserDetailsRequestModel
import com.ythosa.simplespring.app.ws.ui.model.request.UserDetailsRequestModel
import com.ythosa.simplespring.app.ws.ui.model.response.UserRest

interface UserService {
    fun getUsers(): List<UserRest>
    fun getUserById(userId: String): UserRest
    fun createUser(userDetails: UserDetailsRequestModel): UserRest
    fun updateUser(userId: String, userDetails: UpdateUserDetailsRequestModel): UserRest
    fun deleteUser(userId: String)
}
