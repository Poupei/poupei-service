package com.service.poupei.infra.database.entities

import com.service.poupei.domain.model.BankAccount
import jakarta.persistence.*

@Entity(name = "bank_account")
data class BankAccountEntity (
    @Column(name = "bank_account_id") @Id
    val bankAccountId: String,
    val userId: String,
    val bankId: String,
    val name: String,
    @OneToMany
    @JoinColumn
    val cards: List<CardEntity> = listOf(),
    @OneToMany
    @JoinColumn
    val transactions: List<TransactionEntity> = listOf()
) {
    fun toModel(): BankAccount = BankAccount(
        bankAccountId = bankAccountId,
        userId = userId,
        bankId = bankId,
        name = name
    )
}