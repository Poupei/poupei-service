package com.service.poupei.application.controller

import com.service.poupei.application.controller.dto.CreateUserDto
import com.service.poupei.application.controller.dto.UpdateUserDto
import com.service.poupei.application.controller.dto.UserDto
import com.service.poupei.application.usecase.user.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Tag(name = "Users", description = "User controller that is reponsible to do things to related to users")
@Controller
@RequestMapping("/users")
class UserController(
    private val createUserUseCase: CreateUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase,
    private val retrieveAllUsersUseCase: RetrieveAllUsersUseCase,
    private val retrieveUserUseCase: RetrieveUserUseCase
) {

    @Operation(
        summary = "Retrieve all the user",
        responses = [
            ApiResponse(responseCode = "200", description = "Successful in retrieve all users"),
            ApiResponse(responseCode = "204", description = "It doesn't find any users")
        ],
    )
    @GetMapping
    fun retrieveAll() : ResponseEntity<List<UserDto>> =
        ResponseEntity.ok(retrieveAllUsersUseCase.all().map {
            UserDto.from(it)
        })

    @Operation(
        summary = "Retrieve a specific user information",
        responses = [
            ApiResponse(responseCode = "200", description = "Successful user recovery"),
            ApiResponse(responseCode = "404", description = "Not found the user")
        ]
    )
    @GetMapping("/{id}")
    fun retrieveWith(@PathVariable id: String) : ResponseEntity<UserDto> =
        ResponseEntity.ok(UserDto.from(retrieveUserUseCase.with(id)));

    @Operation(
        summary = "Creating a user",
        responses = [
            ApiResponse(responseCode = "200", description = "Successful to create a user"),
            ApiResponse(responseCode = "400", description = "Something is wrong with the field types")
        ],
    )
    @PostMapping
    fun createWith(@RequestBody createUserDto: CreateUserDto) : ResponseEntity<UserDto> =
        ResponseEntity.ok(UserDto.from(createUserUseCase.with(createUserDto.toModel())));

    @Operation(
        summary = "Update a specific user information",
        responses = [
            ApiResponse(responseCode = "200", description = "successful in updating the user information"),
            ApiResponse(responseCode = "204", description = "Successful in request, but nothing it was update"),
            ApiResponse(responseCode = "404", description = "Not found the user")
        ]
    )
    @PutMapping("/{id}")
    fun updateWith(@PathVariable id: String, updateUserDto: UpdateUserDto) : ResponseEntity<UserDto> =
        ResponseEntity.ok(UserDto.from(updateUserUseCase.with(updateUserDto.toModelWith(id))))

    @Operation(
        summary = "Delete a user",
        responses = [
            ApiResponse(responseCode = "200", description = "Successful to delete the user"),
            ApiResponse(responseCode = "404", description = "Not found the user")
        ]
    )
    @DeleteMapping("/{id}")
    fun deleteWith(@PathVariable id: String) : ResponseEntity<UserDto> =
        ResponseEntity.ok(UserDto.from(deleteUserUseCase.with(id)));


}