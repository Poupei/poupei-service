package com.service.poupei.infra.database.entities

import com.service.poupei.domain.model.BankAccount
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "bank_account")
data class BankAccountEntity (
    @Column(name = "bank_account_id") @Id
    val bankAccountId: String,
    val userId: String,
    val bankId: String,
    val name: String
) {
    fun toModel(): BankAccount = BankAccount(
        bankAccountId = bankAccountId,
        userId = userId,
        bankId = bankId,
        name = name
    )
}