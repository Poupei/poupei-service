package com.service.poupei.domain.model

import com.service.poupei.infra.database.entities.TransactionEntity
import com.service.poupei.infra.database.entities.UserEntity
import java.util.UUID

data class User(
    val userId: String = UUID.randomUUID().toString(),
    val name: String,
    val email: String,
    val password: String,
    val limitSpend: Double?,
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
