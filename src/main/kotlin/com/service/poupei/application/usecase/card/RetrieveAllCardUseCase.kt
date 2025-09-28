package com.service.poupei.application.usecase.card

import com.service.poupei.domain.gateways.CardGateway
import org.springframework.stereotype.Component

@Component
class RetrieveAllCardUseCase(
    private val cardGateway: CardGateway
) {
    fun all() = cardGateway.retrieveAll()
}