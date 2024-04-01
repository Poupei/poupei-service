package com.service.poupei.application.usecase.user

import com.service.poupei.domain.gateways.AllUser
import com.service.poupei.domain.model.User
import org.springframework.stereotype.Component

@Component
class DeleteUserUseCase(
    private val allUserUse: AllUser
) {
    fun with(id: String) : User =
        allUserUse.deleteWith(id)
}