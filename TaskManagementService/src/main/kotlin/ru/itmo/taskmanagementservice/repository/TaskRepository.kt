package ru.itmo.taskmanagementservice.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.itmo.taskmanagementservice.model.Task
import ru.itmo.taskmanagementservice.model.TaskPriority
import ru.itmo.taskmanagementservice.model.TaskStatus

@Repository
interface TaskRepository : JpaRepository<Task, Long> {
    fun findByTitleContainingIgnoreCase(title: String): List<Task>

    fun findByStatus(status: TaskStatus): List<Task>

    fun findByPriority(priority: TaskPriority): List<Task>

    fun findByAssignedTo(userId: Long): List<Task>

    fun findByProjectId(projectId: Long): List<Task>
}
