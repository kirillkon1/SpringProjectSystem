package ru.itmo.analyticsservice.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.itmo.analyticsservice.model.TaskEvent

@Repository
interface TaskEventRepository : JpaRepository<TaskEvent, Long> {
    fun findByTaskId(taskId: Long): TaskEvent?

    fun findByAssignedTo(userId: Long): List<TaskEvent>
}
