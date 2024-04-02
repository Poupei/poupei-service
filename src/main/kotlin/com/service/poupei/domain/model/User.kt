package com.service.poupei.domain.model

import com.service.poupei.infra.database.entities.UserEntity
import java.math.BigDecimal
import java.util.*

data class User(
    val userId: String = UUID.randomUUID().toString(),
    val name: String,
    val email: String,
    val password: String,
    val limitSpend: BigDecimal?,
    val dueDate: String?
) {
    fun toEntity(): UserEntity =
        UserEntity(
            userId = userId,
            name = name,
            email = email,
            password = password,
            limitSpend = limitSpend,
            dueDate = dueDate
        )
}
