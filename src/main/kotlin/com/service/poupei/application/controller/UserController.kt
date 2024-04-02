package com.service.poupei.application.controller

import com.service.poupei.application.controller.dto.CreateUserDto
import com.service.poupei.application.controller.dto.UpdateUserDto
import com.service.poupei.application.controller.dto.UserDto
import com.service.poupei.application.usecase.user.*
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

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
        ResponseEntity.ok(UserDto.from(updateUserUseCase.with(updateUserDto.toModelWith(id))))

    @DeleteMapping("/{id}")
    fun deleteWith(@PathVariable id: String) : ResponseEntity<UserDto> =
        ResponseEntity.ok(UserDto.from(deleteUserUseCase.with(id)));


}