package com.service.poupei.domain.model

import com.service.poupei.infra.database.entities.BankEntity
import java.util.*

data class Bank(
    val bankId: String = UUID.randomUUID().toString(),
    val name: String,
    val code: String,
    val logo: String
) {
    fun toEntity(): BankEntity = BankEntity(
        bankId = bankId,
        name = name,
        code = code,
        logo = logo
    )
}
