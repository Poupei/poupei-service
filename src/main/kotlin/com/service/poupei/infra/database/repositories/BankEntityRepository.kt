package com.service.poupei.infra.database.repositories

import com.service.poupei.infra.database.entities.BankEntity
import org.springframework.data.repository.CrudRepository

interface BankEntityRepository : CrudRepository<BankEntity, String>