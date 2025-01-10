package ru.itmo.taskmanagementservice.kafka.service

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import ru.itmo.apiobjects.kafka.model.TaskResponse

@Service
class TaskResponseService(private val kafkaTemplate: KafkaTemplate<String, TaskResponse>) {
    fun sendTaskResponse(response: TaskResponse) {
        kafkaTemplate.send("task-responses", response.correlationId, response)
    }
}
