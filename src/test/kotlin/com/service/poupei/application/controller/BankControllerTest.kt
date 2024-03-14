package com.service.poupei.application.controller

import com.service.poupei.application.usecase.bank.*
import com.service.poupei.domain.model.Bank
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

    @Test
    fun `should return status 200 with body when request for retrieve all banks`() {
        Mockito.`when`(
            retrieveAllBankUseCase.all()
        ).thenReturn(anBankList)

        mockMvc.get("/banks").andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { content { string(anBankListResponse) } }
        }
    }

}
private const val logoPrefix = "poupei-app-multimedia"

private val anBankList = listOf<Bank>(
    Bank(
        bankId = "5076a6f0-a5ff-45aa-ab0c-b94d9ef94241",
        name = "Banco Safra",
        code = "422",
        logo = "$logoPrefix/banco-safra-logo"
    ),
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