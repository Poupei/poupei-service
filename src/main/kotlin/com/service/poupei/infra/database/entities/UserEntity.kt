package com.service.poupei.infra.database.entities

import com.service.poupei.domain.model.User
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Entity
@Table(name = "user")
data class UserEntity(

    @Id
    @Size(max = 26)
    val userId: String,

    @NotBlank
    @Size(max = 45)
    val name: String,

    @NotBlank
    @Size(max = 45)
    val email: String,

    @NotBlank
    val password: String,


    val limitSpend: Double?,

    val dueDate: String?,

    @OneToMany
    @JoinColumn
    val transactions: List<TransactionEntity> = listOf()

) {
    fun toModel() : User =
        User(
            userId = userId,
            name = name,
            email = email,
            password = password,
            limitSpend = limitSpend,
            dueDate = dueDate
        )
}
