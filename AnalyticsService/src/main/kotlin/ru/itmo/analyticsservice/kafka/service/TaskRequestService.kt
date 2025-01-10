@file:Suppress("ktlint:standard:no-wildcard-imports")

package ru.itmo.analyticsservice.kafka.service

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import ru.itmo.apiobjects.kafka.model.TaskRequest
import java.util.*

@Service
class TaskRequestService(private val kafkaTemplate: KafkaTemplate<String, TaskRequest>) {
    fun sendTaskRequest(taskId: Long): String {
        val correlationId = UUID.randomUUID().toString()
        val request = TaskRequest(correlationId, taskId)
        kafkaTemplate.send("task-requests", request.correlationId, request)
        return correlationId
    }
}
