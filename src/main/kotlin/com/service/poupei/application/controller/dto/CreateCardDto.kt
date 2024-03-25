package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.Card

class CreateCardDto(
    val nickname: String,
    val type: String
) {
    fun toModel(accountId: String): Card = Card(
        accountId = accountId,
        nickname = nickname,
        type = type
    )
}