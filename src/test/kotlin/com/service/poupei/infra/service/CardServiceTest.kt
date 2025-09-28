package com.service.poupei.infra.service

import com.service.poupei.domain.enums.card.CardType
import com.service.poupei.domain.model.Card
import com.service.poupei.domain.service.CardService
import com.service.poupei.infra.database.entities.CardEntity
import com.service.poupei.infra.database.repositories.CardEntityRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class CardServiceTest : StringSpec({
    val cardRepository = mockk<CardEntityRepository>()
    val cardService = CardService(
        cardRepository
    )

    "should retrieve an list of cards when request to list all cards" {
        every { cardRepository.findAll() } returns anCardEntityList
        cardService.retrieveAll() shouldBe anCardModelList
        verify { cardRepository.findAll() }
    }
})
private val anCardEntityList = listOf(
    CardEntity(
        cardId = "CardId",
        bankAccountId = "bankAccountId",
        nickname = "nickname",
        type = "DEBIT"
    ),
    CardEntity(
        cardId = "CardId2",
        bankAccountId = "bankAccountId2",
        nickname = "nickname2",
        type = "CREDIT"
    )
)

private val anCardModelList = listOf(
    Card(
        cardId = "CardId",
        bankAccountId = "bankAccountId",
        nickname = "nickname",
        type = CardType.DEBIT
    ),
    Card(
        cardId = "CardId2",
        bankAccountId = "bankAccountId2",
        nickname = "nickname2",
        type = CardType.CREDIT
    )
)