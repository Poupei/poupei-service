package com.service.poupei.infra.database.repositories

import com.service.poupei.infra.database.entities.TransactionEntity
import org.springframework.data.repository.CrudRepository

interface TransactionEntityRepository : CrudRepository<TransactionEntity, String> {

}