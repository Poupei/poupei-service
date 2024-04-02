package com.service.poupei.application.controller.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.service.poupei.domain.model.User
import java.math.BigDecimal

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserDto(
    val userId: String,
    val name: String,
    val email: String,
    val limitSpend: BigDecimal?,
    val dueDate: String?
) {
    companion object {
        fun from(user: User) : UserDto =
            UserDto(
                userId = user.userId,
                name = user.name,
                email = user.email,
                limitSpend = user.limitSpend,
                dueDate = user.dueDate
            )
    }
}
