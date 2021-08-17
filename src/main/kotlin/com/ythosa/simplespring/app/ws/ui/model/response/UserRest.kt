package com.ythosa.simplespring.app.ws.ui.model.response

class UserRest(
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val password: String?,
    val userId: String?,
) {
    data class Builder(
        var firstName: String? = null,
        var lastName: String? = null,
        var email: String? = null,
        var password: String? = null,
        var userId: String? = null,
    ) {
        fun firstName(firstName: String) = apply { this.firstName = firstName }
        fun lastName(lastName: String) = apply { this.lastName = lastName }
        fun email(email: String) = apply { this.email = email }
        fun password(password: String) = apply { this.password = password }
        fun userId(userId: String) = apply { this.userId = userId }
        fun build() = UserRest(firstName, lastName, email, password, userId)
    }
}
