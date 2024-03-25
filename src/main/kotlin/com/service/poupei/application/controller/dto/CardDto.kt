package com.service.poupei.application.controller.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.service.poupei.domain.model.Card

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CardDto(
    val cardId: String,
    val accountId: String,
    val nickname: String,
    val type: String
) {
    companion object {
        fun from(card: Card): CardDto = CardDto(
            cardId = card.cardId,
            accountId = card.accountId,
            nickname = card.nickname,
            type = card.type
        )
    }
}
