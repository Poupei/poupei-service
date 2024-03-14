package com.service.poupei.infra.service

import com.service.poupei.domain.gateways.AllCard
import com.service.poupei.domain.model.Card
import org.springframework.stereotype.Service

@Service
class CardService: AllCard {
    override fun retrieveAll(): List<Card> {
        TODO("Not yet implemented")
    }

    override fun retrieveWith(id: String): Card {
        TODO("Not yet implemented")
    }

    override fun createWith(card: Card): Card {
        TODO("Not yet implemented")
    }

    override fun updateWith(card: Card): Card {
        TODO("Not yet implemented")
    }

    override fun deleteWith(id: String): Card {
        TODO("Not yet implemented")
    }
}