package com.service.poupei.application.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.service.poupei.domain.enums.card.CardType
import com.service.poupei.domain.model.Card

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UpdateCardDto (
    @JsonProperty("bank_account_id")
    val accountId: String,
    val nickname: String,
    val type: CardType
) {
    fun toModel(id: String): Card = Card(
        cardId = id,
        bankAccountId = accountId,
        nickname = nickname,
        type = type
    )
}