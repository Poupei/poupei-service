package com.service.poupei.application.controller

import com.service.poupei.application.controller.dto.TransactionDto
import com.service.poupei.application.usecase.transaction.*
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/transactions")
class TransactionController(
        private val createTransactionUseCase: CreateTransactionUseCase,
        private val deleteTransactionUseCase: DeleteTransactionUseCase,
        private val updateTransactionUseCase: UpdateTransactionUseCase,
        private val retrieveAllTransactionsUseCase: RetrieveAllTransactionsUseCase,
        private val retrieveTransactionUseCase: RetrieveTransactionUseCase
) {


    @GetMapping
    fun retrieveAll(): ResponseEntity<List<TransactionDto>> =
            ResponseEntity.ok(retrieveAllTransactionsUseCase.all())

    @GetMapping("/{id}")
    fun retrieveWith(@PathVariable id: String): ResponseEntity<TransactionDto> =
            ResponseEntity.ok()

    @PostMapping
    fun createWith(@RequestBody @Valid): ResponseEntity<TransactionDto> =

    @PutMapping("/{id}")
    fun updateWith(@PathVariable id: String, @RequestBody @Valid): ResponseEntity<TransactionDto> =


    @DeleteMapping("/{id}")
    fun deleteWith(@PathVariable id: String): ResponseEntity<TransactionDto> =
}