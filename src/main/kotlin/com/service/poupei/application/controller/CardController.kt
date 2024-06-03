package com.service.poupei.application.controller

import com.service.poupei.application.controller.dto.CardDto
import com.service.poupei.application.controller.dto.CreateCardDto
import com.service.poupei.application.controller.dto.UpdateCardDto
import com.service.poupei.application.usecase.card.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
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
    @Operation(
        summary = "Retrieve all the cards",
        responses = [
            ApiResponse(responseCode = "200", description = "Successful in retrieve all cards"),
            ApiResponse(responseCode = "204", description = "It doesn't find any card"),
            ApiResponse(responseCode = "503", description = "External dependency has failed")
        ],
    )
    @GetMapping
    fun retrieveAll(): ResponseEntity<List<CardDto>> = retrieveAllCardUseCase.all().let { list ->
        when {
            list.isEmpty() -> ResponseEntity.noContent().build()
            else -> ResponseEntity.ok().body(list.map { CardDto.from(it) })
        }
    }

    @Operation(
        summary = "Retrieve a specific card information",
        responses = [
            ApiResponse(responseCode = "200", description = "Successful card recovery"),
            ApiResponse(responseCode = "404", description = "Not found the card"),
            ApiResponse(responseCode = "503", description = "External dependency has failed")
        ]
    )
    @GetMapping("/{id}")
    fun retrieveWith(@PathVariable id: String): ResponseEntity<CardDto> =
        ResponseEntity.ok(CardDto.from(retrieveCardUseCase.with(id)))

    @Operation(
        summary = "Adding a card",
        responses = [
            ApiResponse(responseCode = "201", description = "Successful to add card"),
            ApiResponse(responseCode = "400", description = "Something is wrong with the field types"),
            ApiResponse(responseCode = "503", description = "External dependency has failed")
        ],
    )
    @PostMapping
    fun createWith(@RequestBody @Valid createCardDto: CreateCardDto): ResponseEntity<CardDto> =
        ResponseEntity.status(HttpStatus.CREATED)
            .body(CardDto.from(createCardUseCase.with(createCardDto.toModel())))

    @Operation(
        summary = "Update a specific card",
        responses = [
            ApiResponse(responseCode = "200", description = "Successful in updating the card"),
            ApiResponse(responseCode = "204", description = "Successful in request, but nothing it was update"),
            ApiResponse(responseCode = "404", description = "Not found the card"),
            ApiResponse(responseCode = "503", description = "External dependency has failed")
        ]
    )
    @PutMapping("/{id}")
    fun updateWith(
            @RequestBody @Valid updateCardDto: UpdateCardDto,
            @PathVariable id: String
    ): ResponseEntity<CardDto> =
        ResponseEntity.ok().body(CardDto.from(updateCardUseCase.with(updateCardDto.toModel(id))))

    @Operation(
        summary = "Delete a card",
        responses = [
            ApiResponse(responseCode = "200", description = "Successful to delete the card"),
            ApiResponse(responseCode = "404", description = "Not found the card"),
            ApiResponse(responseCode = "503", description = "External dependency has failed")
        ]
    )
    @DeleteMapping("/{id}")
    fun deleteWith(@PathVariable id: String): ResponseEntity<CardDto> =
        ResponseEntity.ok().body(CardDto.from(deleteCardUseCase.with(id)))
}
