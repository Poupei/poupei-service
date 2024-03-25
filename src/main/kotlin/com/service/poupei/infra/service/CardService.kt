package com.service.poupei.infra.service

import com.service.poupei.domain.gateways.AllCard
import com.service.poupei.domain.model.Card
import com.service.poupei.infra.database.repositories.CardEntityRepository
import com.service.poupei.infra.exceptions.NotFoundException
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class CardService(
    private val cardEntityRepository: CardEntityRepository
) : AllCard {
    override fun retrieveAll(): List<Card> =
        cardEntityRepository.findAll().map { it.toModel() }

    override fun retrieveWith(id: String): Card =
        cardEntityRepository.findById(id).getOrNull()?.toModel() ?: throw NotFoundException(
            "Not found card with id $id"
        )

    override fun createWith(card: Card): Card =
        cardEntityRepository.save(card.toEntity()).toModel()

    override fun updateWith(card: Card): Card =
        retrieveWith(card.cardId).let {
            cardEntityRepository.save(card.toEntity()).toModel()
        }

    override fun deleteWith(id: String): Card =
        retrieveWith(id).let {
            cardEntityRepository.deleteById(id)
            it
        }
}