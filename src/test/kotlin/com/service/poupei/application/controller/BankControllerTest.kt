package com.service.poupei.application.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.service.poupei.application.controller.dto.BankDto
import com.service.poupei.application.controller.dto.CreateBankDto
import com.service.poupei.application.controller.exceptionhandler.ErrorDto
import com.service.poupei.application.controller.exceptionhandler.ErrorType.NOT_FOUND
import com.service.poupei.application.controller.exceptionhandler.ErrorType.UNEXPECTED
import com.service.poupei.application.usecase.bank.*
import com.service.poupei.domain.model.Bank
import com.service.poupei.infra.exceptions.NotFoundException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import java.io.File

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class BankControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var retrieveAllBankUseCase: RetrieveAllBankUseCase

    @MockBean
    private lateinit var retrieveBankUseCase: RetrieveBankUseCase

    @MockBean
    private lateinit var createBankUseCase: CreateBankUseCase

    @MockBean
    private lateinit var updateBankUseCase: UpdateBankUseCase

    @MockBean
    private lateinit var deleteBankUseCase: DeleteBankUseCase

    private val objectMapper = ObjectMapper()

    @Test
    fun `should return status 200 with body when request for retrieve all banks`() {
        Mockito.`when`(retrieveAllBankUseCase.all()).thenReturn(anBankList)

        val result = mockMvc.get("/banks").andExpect {
            status  { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }.andReturn()

        assertThat(result.response.contentAsString).isEqualTo(anBankListResponse)
    }

    @Test
    fun `should return status 404 with error body when request for retrieve all banks when bank list is empty`() {
        Mockito.`when`(retrieveAllBankUseCase.all()).thenThrow(NotFoundException("not found"))

        val result = mockMvc.get("/banks").andExpect {
            status  { isNotFound() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }.andReturn()

        assertThat(result.response.contentAsString).isEqualTo(toJson(anErrorDto404))
    }

    @Test
    fun `should return status 500 when request for retrieve all banks with error`() {
        Mockito.`when`(retrieveAllBankUseCase.all()).thenThrow(RuntimeException())

        val result = mockMvc.get("/banks").andExpect {
            status  { isInternalServerError() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }.andReturn()

        assertThat(result.response.contentAsString).isEqualTo(toJson(anErrorDto500))
    }

    @Test
    fun `should return status 200 with body when request for retrieve bank with valid id`() {
        Mockito.`when`(retrieveBankUseCase.with(bankId)).thenReturn(anBankSafra)

        val result = mockMvc.get("/banks/$bankId").andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }.andReturn()

        assertThat(result.response.contentAsString).isEqualTo(toJson(BankDto.from(anBankSafra)))
    }

    @Test
    fun `should return status 404 with error body when request for retrieve bank with invalid id`() {
        val errorMessage = "not found bank with id $bankId"
        Mockito.`when`(retrieveBankUseCase.with(bankId)).thenThrow(
            NotFoundException(errorMessage)
        )

        val result = mockMvc.get("/banks/$bankId").andExpect {
            status { isNotFound() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }.andReturn()

        assertThat(result.response.contentAsString).isEqualTo(toJson(anErrorDto404.copy(message = errorMessage)))
    }

    @Test
    fun `should return status 200 with body when request for create bank`() {
        Mockito.`when`(createBankUseCase.with(anCreateBankSafra)).thenReturn(anBankSafra)

        val result = mockMvc.post("/banks") {
            content = toJson(anCreateBankDto)
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isCreated() }
        }.andReturn()

        assertThat(result.response.contentAsString).isEqualTo(toJson(BankDto.from(anBankSafra)))
    }

    @Test
    fun `should return status 400 when request for create bank with invalid fields`() {
        mockMvc.post("/banks") {
            content = anInvalidBodyJson
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isBadRequest() }
        }.andReturn()
    }

    private fun toJson(obj: Any): String =
        objectMapper.writeValueAsString(obj)
}

private const val bankId = "5076a6f0-a5ff-45aa-ab0c-b94d9ef94241"

private const val logoPrefix = "poupei-app-multimedia"

private val anCreateBankSafra = Bank(
    bankId = null,
    name = "Banco Safra",
    code = "422",
    logo = "$logoPrefix/banco-safra-logo"
)

private val anBankSafra = Bank(
    bankId = bankId,
    name = "Banco Safra",
    code = "422",
    logo = "$logoPrefix/banco-safra-logo"
)

private val anCreateBankDto = CreateBankDto(
    name = "Banco Safra",
    code = "422",
    logo = "$logoPrefix/banco-safra-logo"
)

private val anInvalidBodyJson = """
    {"invalid": "body"}
""".trimIndent()

private val anBankList = listOf<Bank>(
    anBankSafra,
    Bank(
        bankId = "574420b8-ca42-4878-862e-1b210555a022",
        name = "Banco C6 S.A",
        code = "336",
        logo = "$logoPrefix/banco-c6-logo"
    )
)

private val anBankListResponse = File(
    "src/test/kotlin/com/service/poupei/application/fixtures/retrieveAllBankList.json"
).readText()

private val anErrorDto404 = ErrorDto(
    status = 404,
    type = NOT_FOUND,
    message = "not found"
)

private val anErrorDto500 = ErrorDto(
    status = 500,
    type = UNEXPECTED,
    message = "Unhandled exception java.lang.RuntimeException"
)