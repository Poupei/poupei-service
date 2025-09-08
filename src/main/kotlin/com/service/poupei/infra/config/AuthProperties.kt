package com.service.poupei.infra.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated

@ConfigurationProperties("app.auth")
@Validated
data class AuthProperties(
    val sharedSecret: String
)
