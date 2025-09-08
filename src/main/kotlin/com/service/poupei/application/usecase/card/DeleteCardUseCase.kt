package com.service.poupei.application.usecase.card

import com.service.poupei.domain.gateways.AllCard
import com.service.poupei.domain.model.Card
import org.springframework.stereotype.Component

@Component
class DeleteCardUseCase(
    private val allCard: AllCard
) {
    fun with(id: String): Card = allCard.deleteWith(id)
}