package com.sunshijo.global.security

import com.sunshijo.domain.teacher.spi.UserSecurityPort
import com.sunshijo.global.annotation.Adapter
import org.springframework.security.crypto.password.PasswordEncoder

@Adapter
class SecurityFacadeAdapter (
        private val passwordEncoder: PasswordEncoder
) : UserSecurityPort {

    override fun matches(rawPassword: String, encodedPassword: String): Boolean =
            passwordEncoder.matches(rawPassword, encodedPassword)
}