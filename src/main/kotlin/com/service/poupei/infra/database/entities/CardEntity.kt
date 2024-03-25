package com.service.poupei.infra.database.entities

import com.service.poupei.domain.model.Card
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "card")
class CardEntity (
    @Column(name = "card_id") @Id
    val cardId: String,
    val bankAccountId: String,
    val nickname: String,
    val type: String
) {
    fun toModel(): Card =
        Card(
            cardId = cardId,
            bankAccountId = bankAccountId,
            nickname = nickname,
            type = type
        )
}