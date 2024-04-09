package com.service.poupei.application.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.service.poupei.domain.model.User
import java.math.BigDecimal

data class UpdateUserDto(
    val name: String,
    val email: String,
    val password: String,
    @JsonProperty("limit_spend")
    val limitSpend: BigDecimal,
    @JsonProperty("due_date")
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
