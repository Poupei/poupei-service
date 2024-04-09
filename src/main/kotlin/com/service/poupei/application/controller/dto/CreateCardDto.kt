package com.service.poupei.application.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.service.poupei.domain.enums.card.CardType
import com.service.poupei.domain.model.Card

class CreateCardDto(
    @JsonProperty("bank_account_id")
    val bankAccountId: String,
    val nickname: String,
    val type: CardType
) {
    fun toModel(): Card = Card(
        bankAccountId = bankAccountId,
        nickname = nickname,
        type = type
    )
}