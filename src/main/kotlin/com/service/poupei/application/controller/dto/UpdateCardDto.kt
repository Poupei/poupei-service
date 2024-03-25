package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.Card

data class UpdateCardDto (
    val cardId: String,
    val accountId: String,
    val nickname: String,
    val type: String
) {
    fun toModel(): Card = Card(
        cardId = cardId,
        bankAccountId = accountId,
        nickname = nickname,
        type = type
    )
}