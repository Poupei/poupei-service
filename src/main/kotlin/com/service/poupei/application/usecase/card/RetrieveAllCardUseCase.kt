package com.service.poupei.application.usecase.card

import com.service.poupei.domain.gateways.AllCard

class RetrieveAllCardUseCase(
    private val allCard: AllCard
) {
    fun all() = allCard.retrieveAll()
}