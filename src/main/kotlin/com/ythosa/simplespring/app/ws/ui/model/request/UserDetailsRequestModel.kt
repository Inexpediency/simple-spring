package com.ythosa.simplespring.app.ws.ui.model.request

import javax.validation.constraints.*

class UserDetailsRequestModel {
    @NotNull(message = "first name cannot be null")
    @Size(min = 2, message = "first name must not be less than 2 characters")
    val firstName: String? = null

    @NotNull(message = "last name cannot be null")
    @Size(min = 2, message = "last name must not be less than 2 characters")
    val lastName: String? = null

    @NotNull(message = "email cannot be null")
    @Email
    val email: String? = null

    @NotNull(message = "password cannot be null")
    @Size(min = 5, max = 16, message = "password must be 5..16 characters")
    val password: String? = null
}
