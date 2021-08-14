package com.ythosa.simplespring.app.ws.ui.model.request

import javax.validation.constraints.*

class UserDetailsRequestModel {
    @NotNull(message = "firstName cannot be null")
    val firstName: String? = null

    @NotNull(message = "lastName cannot be null")
    val lastName: String? = null

    @Email
    @NotNull(message = "email cannot be null")
    val email: String? = null

    @Size(min = 5, max = 16)
    @NotNull(message = "password cannot be null")
    val password: String? = null
}
