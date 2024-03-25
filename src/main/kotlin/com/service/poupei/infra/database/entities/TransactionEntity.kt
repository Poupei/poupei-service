package com.service.poupei.infra.database.entities

import com.service.poupei.domain.model.Transaction
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.format.annotation.DateTimeFormat


@Entity
@Table(name = "transaction_account")
class TransactionEntity(

    @Id
    private val transactionId: String,

    @OneToMany
    @JoinColumn(name = "user_id")
    private val userId: String,

    @NotBlank
    @Size(max = 45)
    private val method: String,

    @NotNull
    private val type: Int,

    @NotNull
    private val value: Double,

    @NotNull
    @DateTimeFormat()
    private val datetime: String,

    @OneToMany
    @JoinColumn(name = "account_id")
    private val accountId: String,

    @OneToMany
    @JoinColumn(name = "card_id")
    private val cardId: String,

    @NotBlank
    @Size(max = 100)
    private val description: String,

    @NotNull
    private val installment: Int,

    @NotNull
    private val maxInstallment: Int

) {
    fun toModel() : Transaction =
        Transaction(
            transactionId = this.transactionId,
            userId = this.userId,
            method = this.method,
            type = this.type,
            value = this.value,
            datetime = this.datetime,
            accountId = this.accountId,
            cardId = this.cardId,
            description = this.description,
            installment = this.installment,
            maxInstallment = this.maxInstallment
        )
}