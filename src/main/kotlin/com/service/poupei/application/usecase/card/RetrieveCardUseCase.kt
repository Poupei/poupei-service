package com.service.poupei.application.usecase.card

import com.service.poupei.domain.gateways.CardGateway
import org.springframework.stereotype.Component

@Component
class RetrieveCardUseCase(
    private val cardGateway: CardGateway
) {
    fun with(id: String) = cardGateway.retrieveWith(id)
}