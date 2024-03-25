package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.Card

class CreateCardDto(
    val bankAccountId: String,
    val nickname: String,
    val type: String
) {
    fun toModel(): Card = Card(
        bankAccountId = bankAccountId,
        nickname = nickname,
        type = type
    )
}