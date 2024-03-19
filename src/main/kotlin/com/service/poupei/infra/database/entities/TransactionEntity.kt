//package com.service.poupei.infra.database.entities
//
//import jakarta.persistence.*
//import jakarta.validation.constraints.NotBlank
//import jakarta.validation.constraints.NotNull
//import jakarta.validation.constraints.Size
//import org.springframework.format.annotation.DateTimeFormat
//
//
//@Entity
//@Table(name = "transaction_account")
//class TransactionEntity(
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private val transactionId: String,
//
//
//    private val userId: String,
//
//    @NotBlank
//    @Size(max = 45)
//    private val method: String,
//
//    @NotNull
//    private val type: Int,
//
//    @NotNull
//    private val value: Double,
//
//    @NotNull
//    @DateTimeFormat()
//    private val datetime: String,
//
//
//    private val accountId: String,
//
//
//    private val cardId: String,
//
//    @NotBlank
//    @Size(max = 100)
//    private val description: String,
//
//
//    private val installment: Int,
//    private val maxInstallment: Int
//
//){
//
//
//}