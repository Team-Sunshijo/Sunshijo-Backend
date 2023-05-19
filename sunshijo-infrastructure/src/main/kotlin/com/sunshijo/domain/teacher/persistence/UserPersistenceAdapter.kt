package com.sunshijo.domain.teacher.persistence

import com.sunshijo.domain.teacher.domain.Teacher
import com.sunshijo.domain.teacher.mapper.TeacherMapper
import com.sunshijo.domain.teacher.spi.UserPort
import com.sunshijo.global.annotation.Adapter
import com.sunshijo.global.exception.UserNotFoundException

@Adapter
class UserPersistenceAdapter (
        private val teacherRepository: TeacherRepository,
        private val teacherMapper: TeacherMapper
) : UserPort {

    override fun queryUserByAccountId(accountId: String): Teacher {
        return teacherMapper.toDomain(
                teacherRepository.findByAccountId(accountId) ?:throw UserNotFoundException
        )
    }

    override fun saveUser(teacher: Teacher) {
        teacherRepository.save(teacherMapper.toEntity(teacher))
    }

    override fun existsByAccountId(accountId: String): Boolean =
        teacherRepository.existsByAccountId(accountId)

}