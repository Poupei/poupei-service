package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.User

data class CreateUserDto(
    val userId: String,
    val name: String,
    val email: String,
    val password: String
) {

    fun toModel() : User =
        User(
            userId = userId,
            name = name,
            email = email,
            password = password,
            limitSpend = null,
            dueDate = null
        )
}
