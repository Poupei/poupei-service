package com.service.poupei.domain.model

import com.service.poupei.infra.database.entities.BankAccountEntity
import java.util.*

data class BankAccount(
    val bankAccountId: String = UUID.randomUUID().toString(),
    val userId: String,
    val bankId: String,
    val name: String
) {
    fun toEntity() = BankAccountEntity(
        bankAccountId = bankAccountId,
        userId = userId,
        bankId = bankId,
        name = name
    )
}
