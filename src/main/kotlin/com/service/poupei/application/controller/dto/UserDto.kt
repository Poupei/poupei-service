package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.User
import org.eclipse.jetty.util.security.Password

data class UserDto(
    val name: String,
    val email: String,
    val limitSpend: Double?,
    val dueDate: String?
) {
    companion object {
        fun from(user: User) : UserDto =
            UserDto(
                name = user.name,
                email = user.email,
                limitSpend = user.limitSpend,
                dueDate = user.dueDate
            )
    }
}
