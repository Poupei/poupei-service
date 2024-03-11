package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.Card

data class CardDto(
    val cardId: String,
    val accountId: String,
    val nickname: String,
    val type: String
) {
    companion object {
        fun from(card: Card): CardDto = CardDto(
            cardId = card.cardId!!,
            accountId = card.accountId!!,
            nickname = card.nickname,
            type = card.type
        )
    }
}
