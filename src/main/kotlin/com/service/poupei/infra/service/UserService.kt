package com.service.poupei.infra.service

import com.service.poupei.domain.gateways.AllUser
import com.service.poupei.domain.model.User
import com.service.poupei.infra.database.repositories.UserEntityRepository
import com.service.poupei.infra.exceptions.NotFoundException
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class UserService(
    private val userEntityRepository: UserEntityRepository
) : AllUser {
    override fun createWith(user: User): User =
        userEntityRepository.save(user.toEntity()).toModel()
    override fun updateWith(user: User): User =
        retrieve(user.userId).let {
            userEntityRepository.save(user.toEntity()).toModel()
        }

    override fun deleteWith(id: String): User =
        retrieve(id).let {
            userEntityRepository.deleteById(id)
            it
        }

    override fun retrieveAll(): List<User> =
        userEntityRepository.findAll().map { it.toModel() }


    override fun retrieve(id: String): User =
        userEntityRepository.findById(id).getOrNull()?.toModel() ?: throw NotFoundException(
            "Not found user with id $id"
        )
}