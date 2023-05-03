package com.sunshijo.global.security.auth

import com.sunshijo.domain.teacher.persistence.TeacherRepository
import com.sunshijo.global.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class AuthDetailsService (
        private val teacherRepository: TeacherRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = teacherRepository.findByIdOrNull(UUID.fromString(username))
                ?: throw UserNotFoundException
        return AuthDetails(user)
    }
}