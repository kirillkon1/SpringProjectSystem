@file:Suppress("ktlint:standard:no-wildcard-imports")

package ru.itmo.analyticsservice.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.itmo.analyticsservice.kafka.service.TaskRequestService
import ru.itmo.analyticsservice.model.TaskEvent
import ru.itmo.analyticsservice.service.TaskEventService

@RestController
@RequestMapping("/api/analytics")
class AnalyticsController(
    private val taskEventService: TaskEventService,
    private val taskRequestService: TaskRequestService,
) {
    @GetMapping("/tasks")
    fun getAllTasks(): List<TaskEvent> {
        return taskEventService.getAllTaskEvents()
    }

    @GetMapping("/tasks/status")
    fun getTaskCountByStatus(): Map<String, Long> {
        return taskEventService.getTaskCountByStatus()
    }

    @GetMapping("/tasks/priority")
    fun getTaskCountByPriority(): Map<String, Long> {
        return taskEventService.getTaskCountByPriority()
    }

    @PostMapping("/tasks/request")
    fun requestTask(
        @RequestParam taskId: Long,
    ): ResponseEntity<String> {
        val correlationId = taskRequestService.sendTaskRequest(taskId)
        return ResponseEntity.ok("Request sent with Correlation ID: $correlationId")
    }
}
