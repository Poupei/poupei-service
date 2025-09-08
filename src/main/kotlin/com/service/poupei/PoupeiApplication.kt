package com.service.poupei

import com.service.poupei.infra.config.AuthProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(AuthProperties::class)
class PoupeiApplication

fun main(args: Array<String>) {
	runApplication<PoupeiApplication>(*args)
}
