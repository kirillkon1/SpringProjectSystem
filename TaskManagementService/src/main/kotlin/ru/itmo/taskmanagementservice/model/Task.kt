@file:Suppress("ktlint:standard:no-wildcard-imports")

package ru.itmo.taskmanagementservice.model

import jakarta.persistence.*
import ru.itmo.apiobjects.domain.BaseEntity
import java.time.LocalDateTime

@Entity
@Table(name = "tasks")
data class Task(
    var title: String,
    var description: String? = null,
    @Enumerated(EnumType.STRING)
    var status: TaskStatus = TaskStatus.NEW,
    @Enumerated(EnumType.STRING)
    var priority: TaskPriority = TaskPriority.NORMAL,
    var assignedTo: Long, // ID пользователя из User Management Service
    var projectId: Long, // ID проекта из Project Management Service
    var dueDate: LocalDateTime? = null,
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
