package com.sunshijo.global.security

import com.sunshijo.domain.teacher.domain.Teacher
import com.sunshijo.domain.teacher.mapper.TeacherMapper
import com.sunshijo.domain.teacher.persistence.TeacherRepository
import com.sunshijo.domain.teacher.spi.UserSecurityPort
import com.sunshijo.global.annotation.Adapter
import com.sunshijo.global.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder

@Adapter
class SecurityFacadeAdapter(
    private val passwordEncoder: PasswordEncoder,
    private val teacherMapper: TeacherMapper,
    private val teacherRepository: TeacherRepository
) : UserSecurityPort {

    override fun encodePassword(password: String): String =
        passwordEncoder.encode(password)

    override fun matches(rawPassword: String, encodedPassword: String): Boolean =
        passwordEncoder.matches(rawPassword, encodedPassword)

    override fun getCurrentUser(): Teacher {
        val accountId = SecurityContextHolder.getContext().authentication.name
        return teacherMapper.toDomain(teacherRepository.findByAccountId(accountId) ?: throw UserNotFoundException)
    }
}