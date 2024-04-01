package com.service.poupei.infra.database.repositories

import com.service.poupei.infra.database.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserEntityRepository : JpaRepository<UserEntity, String> {
}