package com.service.poupei.application.usecase.card

import com.service.poupei.domain.gateways.AllCard
import com.service.poupei.domain.model.Card
import org.springframework.stereotype.Component

@Component
class UpdateCardUseCase(
    private val allCard: AllCard
) {
    fun with(card: Card) = allCard.updateWith(card)
}