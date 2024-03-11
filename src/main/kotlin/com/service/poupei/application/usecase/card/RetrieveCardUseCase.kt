package com.service.poupei.application.usecase.card

import com.service.poupei.domain.gateways.AllCard

class RetrieveCardUseCase(
    private val allCard: AllCard
) {
    fun with(id: String) = allCard.retrieveWith(id)
}