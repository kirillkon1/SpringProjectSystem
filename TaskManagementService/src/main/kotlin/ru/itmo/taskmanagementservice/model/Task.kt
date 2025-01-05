@file:Suppress("ktlint:standard:no-wildcard-imports")

package ru.itmo.taskmanagementservice.model

import jakarta.persistence.*
import ru.itmo.domain.BaseEntity
import java.time.LocalDateTime

@Entity
@Table(name = "tasks")
data class Task(
    val title: String,
    val description: String? = null,
    @Enumerated(EnumType.STRING)
    val status: TaskStatus = TaskStatus.NEW,
    @Enumerated(EnumType.STRING)
    val priority: TaskPriority = TaskPriority.NORMAL,
    val assignedTo: Long, // ID пользователя из User Management Service
    val projectId: Long, // ID проекта из Project Management Service
    val dueDate: LocalDateTime? = null,
) : BaseEntity()

enum class TaskStatus {
    NEW,
    IN_PROGRESS,
    IN_TESTING,
    DONE,
}

enum class TaskPriority {
    LOW,
    NORMAL,
    HIGH,
    CRITICAL,
}
