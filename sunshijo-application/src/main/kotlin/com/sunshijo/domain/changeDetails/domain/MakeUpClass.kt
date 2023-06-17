package com.sunshijo.domain.changeDetails.domain

class MakeUpClass(

    val id: Long = 0,

    var status: Status,

    var division: Division,

    val changeMasterId: Long,

    val teacherId: Long,

    val requestTimetableId: Long,

    ) {
    fun updateStatus(status: List<Status>): List<MakeUpClass> {
        return status.map {
            MakeUpClass(
                id = this.id,
                status = it,
                division = this.division,
                changeMasterId = this.changeMasterId,
                teacherId = this.teacherId,
                requestTimetableId = this.requestTimetableId
            )
        }
    }
}