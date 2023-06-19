package com.sunshijo.domain.changeMaster.persistence

import com.sunshijo.domain.changeMaster.domain.ChangeMaster
import com.sunshijo.domain.changeMaster.domain.Confirmed.REQUESTING
import com.sunshijo.domain.changeMaster.exception.ChangeMasterNotFoundException
import com.sunshijo.domain.changeMaster.mapper.ChangeMasterMapper
import com.sunshijo.domain.changeMaster.spi.ChangeMasterPort
import com.sunshijo.global.annotation.Adapter
import org.springframework.data.repository.findByIdOrNull
import java.sql.Date

@Adapter
class ChangeMasterPersistenceAdapter(
    private val changeMasterRepository: ChangeMasterRepository,
    private val changeMasterMapper: ChangeMasterMapper
) : ChangeMasterPort {

    override fun saveCommandMaster(teacherId: Long, reason: String, date: Date): ChangeMaster {
        val changeMasterEntity = changeMasterRepository.save(
            changeMasterMapper.toEntity(
                ChangeMaster(
                    reason = reason,
                    confirmed = REQUESTING,
                    date = date,
                    teacherId = teacherId
                )
            )
        )
        return changeMasterMapper.toDomain(changeMasterEntity)
    }

    override fun queryChangeMaster(changeMasterId: Long): ChangeMaster {
        return changeMasterMapper.toDomain(
            changeMasterRepository.findByIdOrNull(changeMasterId) ?: throw ChangeMasterNotFoundException
        )
    }
}