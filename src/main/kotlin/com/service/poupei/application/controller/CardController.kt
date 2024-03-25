package com.service.poupei.application.controller

import com.service.poupei.application.controller.dto.CardDto
import com.service.poupei.application.controller.dto.CreateCardDto
import com.service.poupei.application.controller.dto.UpdateCardDto
import com.service.poupei.application.usecase.card.*
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cards")
class CardController(
    private val retrieveAllCardUseCase: RetrieveAllCardUseCase,
    private val retrieveCardUseCase: RetrieveCardUseCase,
    private val createCardUseCase: CreateCardUseCase,
    private val updateCardUseCase: UpdateCardUseCase,
    private val deleteCardUseCase: DeleteCardUseCase
) {
    @GetMapping
    fun retrieveAll(): ResponseEntity<List<CardDto>> =
        ResponseEntity.ok(retrieveAllCardUseCase.all().map{CardDto.from(it)})

    @GetMapping("/{id}")
    fun retrieveWith(@PathVariable id: String): ResponseEntity<CardDto> =
        ResponseEntity.ok(CardDto.from(retrieveCardUseCase.with(id)))

    @PostMapping("/{accountId}")
    fun createWith(
        @PathVariable accountId: String,
        @RequestBody @Valid createCardDto: CreateCardDto
    ): ResponseEntity<CardDto> =
        ResponseEntity.status(HttpStatus.CREATED)
            .body(CardDto.from(createCardUseCase.with(createCardDto.toModel(accountId))))

    @PutMapping("/{idCard}/accounts/{accountId}")
    fun updateWith(
        @PathVariable idCard: String,
        @PathVariable accountId: String,
        @RequestBody @Valid updateCardDto: UpdateCardDto
    ): ResponseEntity<CardDto> =
        ResponseEntity.ok().body(CardDto.from(updateCardUseCase.with(updateCardDto.toModelWith(idCard, accountId))))

    @DeleteMapping("/{id}")
    fun deleteWith(@PathVariable id: String): ResponseEntity<CardDto> =
        ResponseEntity.ok().body(CardDto.from(deleteCardUseCase.with(id)))
}