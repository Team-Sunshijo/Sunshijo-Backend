package com.sunshijo.domain.changeDetails.domain

import com.sunshijo.annotation.Aggregate

@Aggregate
class ChangeDetails(

    val id: Long = 0,

    var status: Status,

    var division: Division,

    val changeMasterId: Long,

    val teacherId: Long,

    val requestTimetableId: Long,

    val changeTimetableId: Long

) {
    fun updateStatus(status: List<Status>): List<ChangeDetails> {
        return status.map {
            ChangeDetails(
                id = this.id,
                status = it,
                division = this.division,
                changeMasterId = this.changeMasterId,
                teacherId = this.teacherId,
                requestTimetableId = this.requestTimetableId,
                changeTimetableId = this.changeTimetableId
            )
        }
    }
}