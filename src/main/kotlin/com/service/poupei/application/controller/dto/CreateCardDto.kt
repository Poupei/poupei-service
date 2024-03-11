package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.Card

class CreateCardDto(
    private val nickname: String,
    private val type: String
) {
    fun toModel(): Card = Card(
        cardId = null,
        accountId = null,
        nickname = nickname,
        type = type
    )
}