package com.service.poupei.infra.database.entities

import com.service.poupei.domain.model.Bank
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "bank")
class BankEntity(
    @Column(name = "bank_id") @Id
    val bankId: String,
    val name: String,
    val code: String,
    val logo: String
) {
    fun toModel(): Bank =
        Bank(
            bankId = bankId,
            name = name,
            code = code,
            logo = logo
        )
}