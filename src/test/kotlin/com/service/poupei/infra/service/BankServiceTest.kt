package com.service.poupei.infra.service

import com.service.poupei.domain.model.Bank
import com.service.poupei.infra.database.entities.BankEntity
import com.service.poupei.infra.database.repositories.BankEntityRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class BankServiceTest : StringSpec({

    val bankRepository = mockk<BankEntityRepository>()
    val bankService = BankService(
        bankRepository
    )

    "should retrieve an list of banks when request to list all banks" {
        every { bankRepository.findAll() } returns anBankEntityList

        bankService.retrieveAll() shouldBe anBankModelList

        verify { bankRepository.findAll() }
    }
})
private val anBankEntityList = listOf(
    BankEntity(
        bankId = "bankId",
        name = "bankName",
        code = "281",
        logo = "bankLogo"
    ),
    BankEntity(
        bankId = "bankId2",
        name = "bankName2",
        code = "812",
        logo = "bankLogo2"
    )
)

private val anBankModelList = listOf(
    Bank(
        bankId = "bankId",
        name = "bankName",
        code = "281",
        logo = "bankLogo"
    ),
    Bank(
        bankId = "bankId2",
        name = "bankName2",
        code = "812",
        logo = "bankLogo2"
    )
)