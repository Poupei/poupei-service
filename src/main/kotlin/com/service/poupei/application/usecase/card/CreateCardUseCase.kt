package com.service.poupei.application.usecase.card

import com.service.poupei.domain.gateways.CardGateway
import com.service.poupei.domain.model.Card
import org.springframework.stereotype.Component

@Component
class CreateCardUseCase(
    private val cardGateway: CardGateway
) {
    fun with(card: Card): Card = cardGateway.createWith(card)
}