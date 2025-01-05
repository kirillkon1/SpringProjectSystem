package ru.itmo.taskmanagementservice.service.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.itmo.taskmanagementservice.dto.TaskDto
import ru.itmo.taskmanagementservice.model.Task
import ru.itmo.taskmanagementservice.model.TaskPriority
import ru.itmo.taskmanagementservice.model.TaskStatus
import ru.itmo.taskmanagementservice.repository.TaskRepository
import ru.itmo.taskmanagementservice.service.ITaskService

@Service
@Transactional
class TaskService(private val taskRepository: TaskRepository) : ITaskService {
    override fun createTask(dto: TaskDto): Task {
        val task =
            Task(
                title = dto.title!!,
                description = dto.description!!,
                status = dto.status,
                priority = dto.priority,
                assignedTo = dto.assignedTo!!,
                projectId = dto.projectId!!,
                dueDate = dto.dueDate,
            )

        return taskRepository.save(task)
    }

    override fun getTaskById(id: Long): Task {
        return taskRepository.findById(id).orElseThrow {
            RuntimeException("Задача с id $id не найдена")
        }
    }

    override fun updateTask(
        id: Long,
        dto: TaskDto,
    ): Task {
        val existingTask = getTaskById(id)
        val updatedTask =
            existingTask.copy(
                title = dto.title!!,
                description = dto.description!!,
                status = dto.status,
                priority = dto.priority,
                assignedTo = dto.assignedTo!!,
                projectId = dto.projectId!!,
                dueDate = dto.dueDate,
            )

        return taskRepository.save(updatedTask)
    }

    override fun deleteTask(id: Long) {
        val task = getTaskById(id)
        taskRepository.delete(task)
    }

    override fun searchTasks(title: String): List<Task> {
        return taskRepository.findByTitleContainingIgnoreCase(title)
    }

    override fun getAllTasks(): List<Task> {
        return taskRepository.findAll()
    }

    override fun getTasksByStatus(status: TaskStatus): List<Task> {
        return taskRepository.findByStatus(status)
    }

    override fun getTasksByPriority(priority: TaskPriority): List<Task> {
        return taskRepository.findByPriority(priority)
    }

    override fun getTasksByAssignedUser(userId: Long): List<Task> {
        return taskRepository.findByAssignedTo(userId)
    }

    override fun getTasksByProject(projectId: Long): List<Task> {
        return taskRepository.findByProjectId(projectId)
    }
}
