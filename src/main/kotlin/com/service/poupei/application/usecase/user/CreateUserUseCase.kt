package com.service.poupei.application.usecase.user

import com.service.poupei.domain.gateways.UserGateway
import com.service.poupei.domain.model.User
import org.springframework.stereotype.Component

@Component
class CreateUserUseCase(
    private val userGateway: UserGateway
){
    fun with(user: User): User =
        userGateway.createWith(user)
}
