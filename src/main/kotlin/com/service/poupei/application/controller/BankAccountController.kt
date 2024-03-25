package com.service.poupei.application.controller

import com.service.poupei.application.controller.dto.BankAccountDto
import com.service.poupei.application.controller.dto.CreateBankAccountDto
import com.service.poupei.application.controller.dto.UpdateBankAccountDto
import com.service.poupei.application.usecase.bankaccount.*
import jakarta.validation.Valid
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/bank-account")
class BankAccountController(
    private val retrieveAllBankAccountUseCase: RetrieveAllBankAccountUseCase,
    private val retrieveBankAccountUseCase: RetrieveBankAccountUseCase,
    private val createBankAccountUseCase: CreateBankAccountUseCase,
    private val updateBankAccountUseCase: UpdateBankAccountUseCase,
    private val deleteBankAccountUseCase: DeleteBankAccountUseCase
) {

    @GetMapping
    fun retrieveAll(): ResponseEntity<List<BankAccountDto>> =
        ResponseEntity.ok(retrieveAllBankAccountUseCase.all().map { BankAccountDto.from(it) })

    @GetMapping("/{id}")
    fun retrieveWith(@PathVariable id: String): ResponseEntity<BankAccountDto> =
        ResponseEntity.ok(BankAccountDto.from(retrieveBankAccountUseCase.with(id)))

    @PostMapping
    fun create(@RequestBody @Valid createBankAccountDto: CreateBankAccountDto) =
        ResponseEntity.status(CREATED)
            .body(BankAccountDto.from(createBankAccountUseCase.with(createBankAccountDto.toModel())))

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody @Valid updateBankAccountDto: UpdateBankAccountDto) =
        ResponseEntity.ok(BankAccountDto.from(updateBankAccountUseCase.with(updateBankAccountDto.toModel())))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) =
        ResponseEntity.ok(BankAccountDto.from(deleteBankAccountUseCase.with(id)))
}