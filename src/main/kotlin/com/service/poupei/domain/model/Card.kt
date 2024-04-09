package com.service.poupei.domain.model

import com.service.poupei.domain.enums.card.CardType
import com.service.poupei.infra.database.entities.CardEntity
import java.util.*

data class Card(
    val cardId: String = UUID.randomUUID().toString(),
    val bankAccountId: String,
    val nickname: String,
    val type: CardType
) {
    fun toEntity(): CardEntity = CardEntity(
        cardId = cardId,
        bankAccountId = bankAccountId,
        nickname = nickname,
        type = type.toString()
    )
}
