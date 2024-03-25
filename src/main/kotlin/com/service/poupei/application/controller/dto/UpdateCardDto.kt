package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.Card

data class UpdateCardDto (
    val nickname: String,
    val type: String
) {
    fun toModelWith(idCard: String, accountId: String): Card = Card(
        cardId = idCard,
        accountId = accountId,
        nickname = nickname,
        type = type
    )
}