package com.service.poupei.application.controller.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.service.poupei.domain.model.User
import java.math.BigDecimal

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UpdateUserDto(
    val name: String,
    val email: String,
    val password: String,
    val limitSpend: BigDecimal,
    val dueDate: String
) {
    fun toModelWith(id: String) : User =
        User(
            userId = id,
            name = name,
            email = email,
            password = password,
            limitSpend = limitSpend,
            dueDate = dueDate
        )
}
