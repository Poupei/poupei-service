package com.service.poupei.application.controller

import com.service.poupei.application.controller.dto.CreateTransactionDto
import com.service.poupei.application.controller.dto.TransactionDto
import com.service.poupei.application.usecase.transaction.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
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

@Tag(name = "Transaction", description = "Transaction controller that is reponsible to do things about financial movement")
@Controller
@RequestMapping("/transactions")
class TransactionController(
        private val createTransactionUseCase: CreateTransactionUseCase,
        private val deleteTransactionUseCase: DeleteTransactionUseCase,
        private val updateTransactionUseCase: UpdateTransactionUseCase,
        private val retrieveAllTransactionsUseCase: RetrieveAllTransactionsUseCase,
        private val retrieveTransactionUseCase: RetrieveTransactionUseCase
) {


    @Operation(
        summary = "Retrieve all the transactions",
        responses = [
            ApiResponse(responseCode = "200", description = "Successful in retrieve all transactions"),
            ApiResponse(responseCode = "204", description = "It doesn't find any transaction")
        ],
    )
    @GetMapping
    fun retrieveAll(): ResponseEntity<List<TransactionDto>> =
            ResponseEntity.ok(retrieveAllTransactionsUseCase.all().map { transactionModel ->
                TransactionDto.from(transactionModel)
            })

    @Operation(
        summary = "Retrieve a specific transaction information",
        responses = [
            ApiResponse(responseCode = "200", description = "Successful transaction recovery"),
            ApiResponse(responseCode = "404", description = "Not found the transaction")
        ]
    )
    @GetMapping("/{id}")
    fun retrieveWith(@PathVariable id: String): ResponseEntity<TransactionDto> =
            ResponseEntity.ok(TransactionDto.from(
                    retrieveTransactionUseCase.with(id)
            ))

    @Operation(
        summary = "Adding a transaction",
        responses = [
            ApiResponse(responseCode = "200", description = "Successful to add transaction"),
            ApiResponse(responseCode = "400", description = "Something is wrong with the field types")
        ],
    )
    @PostMapping
    fun createWith(@RequestBody @Valid createTransactionDto: CreateTransactionDto): ResponseEntity<TransactionDto> =
            ResponseEntity.ok(TransactionDto.from(
                    createTransactionUseCase.with(createTransactionDto.toModel())
            ))

    @Operation(
        summary = "Update a specific transaction",
        responses = [
            ApiResponse(responseCode = "200", description = "successful in updating the transaction"),
            ApiResponse(responseCode = "204", description = "Successful in request, but nothing it was update"),
            ApiResponse(responseCode = "404", description = "Not found the transaction")
        ]
    )
    @PutMapping("/{id}")
    fun updateWith(
            @PathVariable id: String,
            @RequestBody @Valid createTransactionDto: CreateTransactionDto
    ): ResponseEntity<TransactionDto> =
            ResponseEntity.ok(TransactionDto.from(
                    updateTransactionUseCase.with(id, createTransactionDto.toModel())
            ))


    @Operation(
        summary = "Delete a transaction",
        responses = [
            ApiResponse(responseCode = "200", description = "Successful to delete the transaction"),
            ApiResponse(responseCode = "404", description = "Not found the transaction")
        ]
    )
    @DeleteMapping("/{id}")
    fun deleteWith(@PathVariable id: String): ResponseEntity<TransactionDto> =
            ResponseEntity.ok(TransactionDto.from(deleteTransactionUseCase.with(id)))


}