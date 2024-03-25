package com.service.poupei.domain.model

import com.service.poupei.infra.database.entities.CardEntity
import java.util.*

data class Card(
    val cardId: String = UUID.randomUUID().toString(),
    val bankAccountId: String,
    val nickname: String,
    val type: String
) {
    fun toEntity(): CardEntity = CardEntity(
        cardId = cardId,
        bankAccountId = bankAccountId,
        nickname = nickname,
        type = type
    )
}
