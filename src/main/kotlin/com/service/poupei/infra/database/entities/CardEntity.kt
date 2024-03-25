package com.service.poupei.infra.database.entities

import com.service.poupei.domain.model.Card
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity(name = "card")
class CardEntity (
    @Column(name = "card_id") @Id
    val cardId: String,
    @ManyToOne
    @JoinColumn(name = "account_id")
    val accountId: String,
    val nickname: String,
    val type: String
) {
    fun toModel(): Card =
        Card(
            cardId = cardId,
            accountId = accountId,
            nickname = nickname,
            type = type
        )
}