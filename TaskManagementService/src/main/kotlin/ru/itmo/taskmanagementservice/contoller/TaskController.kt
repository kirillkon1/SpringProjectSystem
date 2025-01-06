@file:Suppress("ktlint:standard:no-wildcard-imports")

package ru.itmo.taskmanagementservice.contoller

import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.itmo.taskmanagementservice.dto.TaskDTO
import ru.itmo.taskmanagementservice.model.Task
import ru.itmo.taskmanagementservice.model.TaskPriority
import ru.itmo.taskmanagementservice.model.TaskStatus
import ru.itmo.taskmanagementservice.service.impl.TaskService

@RestController
@RequestMapping("/api/tasks")
@Validated
class TaskController(private val taskService: TaskService) {
    @PostMapping
    fun createTask(
        @Valid @RequestBody dto: TaskDTO,
    ): ResponseEntity<Task> {
        val createdTask = taskService.createTask(dto)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask)
    }

    @GetMapping("/{id}")
    fun getTaskById(
        @PathVariable @Min(1) id: Long,
    ): ResponseEntity<Task> {
        val task = taskService.getTaskById(id)
        return ResponseEntity.ok(task)
    }

    @PutMapping("/{id}")
    fun updateTask(
        @PathVariable @Min(1) id: Long,
        @Valid @RequestBody dto: TaskDTO,
    ): ResponseEntity<Task> {
        val updatedTask = taskService.updateTask(id, dto)
        return ResponseEntity.ok(updatedTask)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTask(
        @PathVariable @Min(1) id: Long,
    ) {
        taskService.deleteTask(id)
    }

    @GetMapping("/search")
    fun searchTasks(
        @RequestParam name: String,
    ): ResponseEntity<List<Task>> {
        val tasks = taskService.searchTasks(name)
        return ResponseEntity.ok(tasks)
    }

    @GetMapping
    fun getAllTasks(): ResponseEntity<List<Task>> {
        val tasks = taskService.getAllTasks()
        return ResponseEntity.ok(tasks)
    }

    @GetMapping("/status/{status}")
    fun getTasksByStatus(
        @PathVariable status: TaskStatus,
    ): ResponseEntity<List<Task>> {
        val tasks = taskService.getTasksByStatus(status)
        return ResponseEntity.ok(tasks)
    }

    @GetMapping("/priority/{priority}")
    fun getTasksByPriority(
        @PathVariable priority: TaskPriority,
    ): ResponseEntity<List<Task>> {
        val tasks = taskService.getTasksByPriority(priority)
        return ResponseEntity.ok(tasks)
    }

    @GetMapping("/user/{userId}")
    fun getTasksByAssignedUser(
        @PathVariable @Min(1) userId: Long,
    ): ResponseEntity<List<Task>> {
        val tasks = taskService.getTasksByAssignedUser(userId)
        return ResponseEntity.ok(tasks)
    }

    @GetMapping("/project/{projectId}")
    fun getTasksByProject(
        @PathVariable @Min(1) projectId: Long,
    ): ResponseEntity<List<Task>> {
        val tasks = taskService.getTasksByProject(projectId)
        return ResponseEntity.ok(tasks)
    }
}
