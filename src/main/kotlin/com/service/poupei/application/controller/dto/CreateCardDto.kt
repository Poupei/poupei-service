package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.Card

class CreateCardDto(
    val nickname: String,
    val type: String
) {
    fun toModel(): Card = Card(
        cardId = null,
        accountId = null,
        nickname = nickname,
        type = type
    )
}