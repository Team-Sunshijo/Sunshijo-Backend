package com.sunshijo.global.security.auth

import com.sunshijo.domain.teacher.persistence.TeacherRepository
import com.sunshijo.domain.teacher.persistence.entity.TeacherEntity
import com.sunshijo.global.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthDetailsService(
    private val teacherRepository: TeacherRepository
) : UserDetailsService {

    override fun loadUserByUsername(accountId: String): UserDetails {
        val user: TeacherEntity = teacherRepository.findByAccountId(accountId)
            ?: throw UserNotFoundException
        return AuthDetails(user)
    }
}