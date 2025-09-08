package com.service.poupei.application.controller

import com.service.poupei.application.controller.dto.BankDto
import com.service.poupei.application.controller.dto.CreateBankDto
import com.service.poupei.application.controller.dto.UpdateBankDto
import com.service.poupei.application.usecase.bank.*
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/banks")
class BankController(
    private val retrieveAllBankUseCase: RetrieveAllBankUseCase,
    private val retrieveBankUseCase: RetrieveBankUseCase,
    private val createBankUseCase: CreateBankUseCase,
    private val updateBankUseCase: UpdateBankUseCase,
    private val deleteBankUseCase: DeleteBankUseCase
) {

    @GetMapping
    fun retrieveAll(): ResponseEntity<List<BankDto>> =
        ResponseEntity.ok(retrieveAllBankUseCase.all().map { BankDto.from(it) })

    @GetMapping("/{id}")
    fun retrieveWith(@PathVariable id: String): ResponseEntity<BankDto> =
        ResponseEntity.ok(BankDto.from(retrieveBankUseCase.with(id)))

    @PostMapping
    fun createWith(@RequestBody @Valid createBankDto: CreateBankDto): ResponseEntity<BankDto> =
        ResponseEntity
            .status(HttpStatus.CREATED)
            .body(BankDto.from(createBankUseCase.with(createBankDto.toModel())))

    @PutMapping("/{id}")
    fun updateWith(
        @PathVariable id: String,
        @RequestBody @Valid updateBankDto: UpdateBankDto
    ): ResponseEntity<BankDto> =
        ResponseEntity.ok()
            .body(BankDto.from(updateBankUseCase.with(updateBankDto.toModelWith(id))))

    @DeleteMapping("/{id}")
    fun deleteWith(@PathVariable id: String): ResponseEntity<BankDto> =
        ResponseEntity
            .ok()
            .body(BankDto.from(deleteBankUseCase.with(id)))
}