package com.service.poupei.domain.model

import com.service.poupei.infra.database.entities.CardEntity
import java.util.*

data class Card(
    val cardId: String = UUID.randomUUID().toString(),
    val accountId: String,
    val nickname: String,
    val type: String
) {
    fun toEntity(): CardEntity = CardEntity(
        cardId = cardId,
        accountId = accountId,
        nickname = nickname,
        type = type
    )
}
