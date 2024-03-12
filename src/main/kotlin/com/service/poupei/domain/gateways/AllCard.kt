package com.service.poupei.domain.gateways

import com.service.poupei.domain.model.Card

interface AllCard {
    fun retrieveAll(): List<Card>
    fun retrieveWith(id: String): Card
    fun createWith(card: Card): Card
    fun updateWith(card: Card): Card
    fun deleteWith(id: String): Card
}