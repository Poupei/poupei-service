package com.service.poupei.infra.database.repositories

import com.service.poupei.infra.database.entities.CardEntity
import org.springframework.data.repository.CrudRepository

interface CardEntityRepository : CrudRepository<CardEntity, String>