package com.service.poupei.infra.config

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class AuthFilter(private val authProperties: AuthProperties) : OncePerRequestFilter() {

    companion object {
        const val AUTHORIZATION = "Authorization"
    }

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain
    ) {
        val authorization = request.getHeader(AUTHORIZATION)

        val ignorePathsList = authProperties.ignorePaths.split(",")
        val matchToIgnore = ignorePathsList.any { request.requestURI.contains(it) }

        if (authorization == authProperties.sharedSecret || matchToIgnore) {
            val auth = UsernamePasswordAuthenticationToken("user", null, emptyList())
            SecurityContextHolder.getContext().authentication = auth
        } else {
            response.status = HttpServletResponse.SC_UNAUTHORIZED
        }

        chain.doFilter(request, response)
    }
}