package com.service.poupei.application.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.service.poupei.application.controller.dto.*
import com.service.poupei.application.controller.exceptionhandler.ErrorDto
import com.service.poupei.application.controller.exceptionhandler.ErrorType
import com.service.poupei.application.usecase.card.*
import com.service.poupei.domain.enums.card.CardType
import com.service.poupei.domain.model.Card
import com.service.poupei.infra.exceptions.NotFoundException
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockkStatic
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.*
import java.io.File
import java.util.*

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CardControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var retrieveAllCardUseCase: RetrieveAllCardUseCase

    @MockBean
    private lateinit var retrieveCardUseCase: RetrieveCardUseCase

    @MockBean
    private lateinit var createCardUseCase: CreateCardUseCase

    @MockBean
    private lateinit var updateCardUseCase: UpdateCardUseCase

    @MockBean
    private lateinit var deleteCardUseCase: DeleteCardUseCase

    private val objectMapper = ObjectMapper()

    @BeforeEach
    fun setUp() {
        mockkStatic(UUID::class)
        every { UUID.randomUUID().toString() } returns cardId
    }

    @AfterEach
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `should return status 200 with body when request for retrieve all cards`() {
        Mockito.`when`(retrieveAllCardUseCase.all()).thenReturn(anCardList)

        val result = mockMvc.get("/cards").andExpect {
            status  { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }.andReturn()

        Assertions.assertThat(result.response.contentAsString).isEqualTo(anCardListResponse)
    }

    @Test
    fun `should return status 404 with error body when request for retrieve all cards when card list is empty`() {
        Mockito.`when`(retrieveAllCardUseCase.all()).thenThrow(NotFoundException("not found"))

        val result = mockMvc.get("/cards").andExpect {
            status  { isNotFound() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }.andReturn()

        Assertions.assertThat(result.response.contentAsString).isEqualTo(toJson(anErrorDto404))
    }

    @Test
    fun `should return status 500 when request for retrieve all cards with error`() {
        Mockito.`when`(retrieveAllCardUseCase.all()).thenThrow(RuntimeException())

        val result = mockMvc.get("/cards").andExpect {
            status  { isInternalServerError() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }.andReturn()

        Assertions.assertThat(result.response.contentAsString).isEqualTo(toJson(anErrorDto500))
    }

    @Test
    fun `should return status 200 with body when request for retrieve card with valid id`() {
        Mockito.`when`(retrieveCardUseCase.with(cardId)).thenReturn(anCardBradesco)

        val result = mockMvc.get("/cards/$cardId").andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }.andReturn()

        Assertions.assertThat(result.response.contentAsString).isEqualTo(toJson(CardDto.from(anCardBradesco)))
    }

    @Test
    fun `should return status 404 with error body when request for retrieve card with invalid id`() {
        val errorMessage = "not found card with id $cardId"
        Mockito.`when`(retrieveCardUseCase.with(cardId)).thenThrow(
                NotFoundException(errorMessage)
        )

        val result = mockMvc.get("/cards/$cardId").andExpect {
            status { isNotFound() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }.andReturn()

        Assertions.assertThat(result.response.contentAsString).isEqualTo(toJson(anErrorDto404.copy(message = errorMessage)))
    }

    @Test
    fun `should return status 500 when request for retrieve card with an error`() {
        Mockito.`when`(retrieveCardUseCase.with("invalidId")).thenThrow(RuntimeException())

        val result = mockMvc.get("/cards/invalidId").andExpect {
            status  { isInternalServerError() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }.andReturn()

        Assertions.assertThat(result.response.contentAsString).isEqualTo(toJson(anErrorDto500))
    }

    @Test
    fun `should return status 201 with body when request for create card`() {
        Mockito.`when`(createCardUseCase.with(anCreateCardBradesco)).thenReturn(anCardBradesco)

        val result = mockMvc.post("/cards") {
            content = toJson(anCreateCardDto)
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isCreated() }
        }.andReturn()

        Assertions.assertThat(result.response.contentAsString).isEqualTo(toJson(CardDto.from(anCardBradesco)))
    }

    @Test
    fun `should return status 400 when request for create card with invalid fields`() {
        mockMvc.post("/cards") {
            content = anInvalidBodyJson
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isBadRequest() }
        }.andReturn()
    }

    @Test
    fun `should return status 500 when request for create card with an error`() {
        Mockito.`when`(createCardUseCase.with(anCreateCardBradesco)).thenThrow(RuntimeException())

        mockMvc.post("/cards") {
            content = toJson(anCreateCardDto)
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isInternalServerError() }
        }.andReturn()
    }

    @Test
    fun `should return status 200 with body when request for update card`() {
        Mockito.`when`(updateCardUseCase.with(anUpdatedCard)).thenReturn(anUpdatedCard)

        val result = mockMvc.put("/cards/$newCardId") {
            content = toJson(anUpdateCardDto)
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
        }.andReturn()

        Assertions.assertThat(result.response.contentAsString).isEqualTo(toJson(CardDto.from(anUpdatedCard)))
    }

    @Test
    fun `should return status 400 when request for update card with invalid fields`() {
        mockMvc.put("/cards/$newCardId") {
            content = anInvalidBodyJson
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isBadRequest() }
        }.andReturn()
    }

    @Test
    fun `should return status 500 when request for update card with an error`() {
        Mockito.`when`(updateCardUseCase.with(anUpdatedCard)).thenThrow(RuntimeException())

        mockMvc.put("/cards/$newCardId") {
            content = toJson(anUpdatedCard)
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isInternalServerError() }
        }.andReturn()
    }

    @Test
    fun `should return status 200 with body when request for delete card with valid id`(){
        Mockito.`when`(deleteCardUseCase.with(cardId)).thenReturn(anCardBradesco)

        mockMvc.delete("/cards/$cardId").andExpect { status { isOk() } }
    }

    @Test
    fun `should return status 404 with error response when request for delete card with not found id`() {
        Mockito.`when`(deleteCardUseCase.with("notFoundId")).thenThrow(NotFoundException("not found card"))

        val result = mockMvc.delete("/cards/$cardId").andExpect { status { isOk() } }.andReturn()

        Assertions.assertThat(result.response.contentAsString).isEqualTo(toJson(anErrorDto404))
    }

    private fun toJson(obj: Any): String =
        objectMapper.writeValueAsString(obj)
}

private const val cardId = "0ed28483-a1fc-4e67-97fa-ad799dfb628a"
private const val newCardId = "ae00696e-dc18-409d-bd09-f9f69b8921f1"
private const val bankAccountId = "388e901f-8822-4621-8846-f2dada66688a"
private const val newBankAccountId = "af87fe82-51d7-42af-bc6a-10f0c7b7f371"

private val anCreateCardDto = CreateCardDto(
    bankAccountId = bankAccountId,
    nickname = "Cartão Bradesco",
    type = CardType.DEBIT
)

private val anCreateCardBradesco = Card(
    cardId = cardId,
    bankAccountId = bankAccountId,
    nickname = "Cartão Bradesco",
    type = CardType.DEBIT
)

private val anCardBradesco = Card(
    cardId = cardId,
    bankAccountId = bankAccountId,
    nickname = "Cartão Bradesco",
    type = CardType.DEBIT
)

private val anUpdateCardDto = UpdateCardDto(
    accountId = newBankAccountId,
    nickname = "Cartão C6",
    type = CardType.CREDIT
)

private val anInvalidBodyJson = """
    {"invalid": "body"}
""".trimIndent()

private val anCardList = listOf<Card>(
    Card(
        cardId = "06418f2e-6eb8-467d-8814-05b2f5f9bdf1",
        bankAccountId = "53b9a3ed-ca20-401f-82fd-2ab7aa5b9f63",
        nickname = "Cartão Safra",
        type = CardType.DEBIT
    ),
    Card(
        cardId = "ae06220a-fead-4754-aa15-77bbea0d829a",
        bankAccountId = "0f02a3e9-5ca8-4355-b4c4-bd4209452835",
        nickname = "Cartão Itau",
        type = CardType.CREDIT
    )
)

private val anErrorDto404 = ErrorDto(
    status = 404,
    type = ErrorType.NOT_FOUND,
    message = "not found"
)

private val anErrorDto500 = ErrorDto(
    status = 500,
    type = ErrorType.UNEXPECTED,
    message = "Unhandled exception java.lang.RuntimeException"
)

private val anCardListResponse = File(
        "src/test/kotlin/com/service/poupei/application/fixtures/retrieveAllCardList.json"
).readText()

private val anUpdatedCard = anCardBradesco.copy(newCardId)
