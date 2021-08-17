package com.ythosa.simplespring.app.ws.ui.model.request

import javax.validation.constraints.*

class UpdateUserDetailsRequestModel {
    @NotNull(message = "first name cannot be null")
    @Size(min = 2, message = "first name must not be less than 2 characters")
    val firstName: String? = null

    @NotNull(message = "last name cannot be null")
    @Size(min = 2, message = "last name must not be less than 2 characters")
    val lastName: String? = null
}
