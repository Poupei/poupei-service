package com.service.poupei.infra.database.repositories

import com.service.poupei.infra.database.entities.TransactionEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionEntityRepository : JpaRepository<TransactionEntity, String> {

}