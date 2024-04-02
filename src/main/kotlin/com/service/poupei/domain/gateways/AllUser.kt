package com.service.poupei.domain.gateways

import com.service.poupei.domain.model.User

interface AllUser {

    fun createWith(user: User) : User

    fun updateWith(user: User) : User

    fun deleteWith(id: String) : User

    fun retrieveAll() : List<User>

    fun retrieve(id: String) : User
}