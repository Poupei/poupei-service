package com.service.poupei.application.controller

import com.service.poupei.application.controller.dto.CreateUserDto
import com.service.poupei.application.controller.dto.UpdateUserDto
import com.service.poupei.application.controller.dto.UserDto
import com.service.poupei.application.usecase.user.*
import jakarta.websocket.server.PathParam
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
@RequestMapping("/users")
class UserController(
    private val createUserUseCase: CreateUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase,
    private val retrieveAllUserUseCase: RetrieveAllUserUse,
    private val retrieveUserCase: RetrieveUserCase
) {


    @GetMapping
    fun retrieveAll() : ResponseEntity<List<UserDto>> =
        ResponseEntity.ok(retrieveAllUserUseCase.all().map {
            UserDto.from(it)
        })

    @GetMapping("/{id}")
    fun retrieveWith(@PathVariable id: String) : ResponseEntity<UserDto> =
        ResponseEntity.ok(UserDto.from(retrieveUserCase.with(id)));

    @PostMapping
    fun createWith(@RequestBody createUserDto: CreateUserDto) : ResponseEntity<UserDto> =
        ResponseEntity.ok(UserDto.from(createUserUseCase.with(createUserDto.toModel())));

    @PutMapping("/{id}")
    fun updateWith(@PathVariable id: String, updateUserDto: UpdateUserDto) : ResponseEntity<UserDto> =
        ResponseEntity.ok(
            UserDto.from(
                updateUserUseCase.with(id, updateUserDto.toModel())
            ));

    @DeleteMapping("/{id}")
    fun deleteWith(@PathVariable id: String) : ResponseEntity<UserDto> =
        ResponseEntity.ok(UserDto.from(deleteUserUseCase.with(id)));


}