package com.service.poupei.application.usecase.user

import com.service.poupei.domain.gateways.UserGateway
import com.service.poupei.domain.model.User
import org.springframework.stereotype.Component

@Component
class RetrieveAllUsersUseCase(
    private val userGateway: UserGateway
) {
    fun all(): List<User> =
        userGateway.retrieveAll()
}