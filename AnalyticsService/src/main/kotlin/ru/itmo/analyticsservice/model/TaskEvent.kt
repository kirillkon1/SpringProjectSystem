@file:Suppress("ktlint:standard:no-wildcard-imports")

package ru.itmo.analyticsservice.model

import jakarta.persistence.*
import ru.itmo.ru.itmo.apiobjects.domain.BaseEntity
import java.time.LocalDateTime

@Entity
@Table(name = "task_analytics")
data class TaskEvent(
    val taskId: Long,
    val title: String,
    val description: String,
    val dueDate: LocalDateTime,
    val assignedTo: Long,
    val projectId: Long,
    val priority: String,
    val status: String,
) : BaseEntity()
