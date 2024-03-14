package com.service.poupei.application.usecase.card

import com.service.poupei.domain.gateways.AllCard
import org.springframework.stereotype.Component

@Component
class RetrieveAllCardUseCase(
    private val allCard: AllCard
) {
    fun all() = allCard.retrieveAll()
}