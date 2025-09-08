package com.service.poupei.infra.database.repositories

import com.service.poupei.infra.database.entities.BankAccountEntity
import org.springframework.data.repository.CrudRepository

interface BankAccountEntityRepository: CrudRepository<BankAccountEntity, String>