package com.service.poupei.infra.database.repositories

import com.service.poupei.infra.database.entities.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserEntityRepository : CrudRepository<UserEntity, String> {
}