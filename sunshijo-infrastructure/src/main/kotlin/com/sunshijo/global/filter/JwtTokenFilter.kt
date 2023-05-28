package com.sunshijo.global.filter

import com.sunshijo.global.security.jwt.JwtParser
import com.sunshijo.global.security.jwt.JwtProperties
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtTokenFilter(
    private val jwtParser: JwtParser
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = resolvedToken(request)

        token?.let {
            SecurityContextHolder.getContext().authentication = jwtParser.getAuthentication(token)
        }
        filterChain.doFilter(request, response)
    }

    private fun resolvedToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(JwtProperties.HEADER)

        if (bearerToken != null && bearerToken.startsWith(JwtProperties.PREFIX)) {
            return bearerToken.substring(7)
        }
        return null
    }
}