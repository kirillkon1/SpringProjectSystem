package ru.itmo.analyticsservice.kafka.listener

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import ru.itmo.analyticsservice.model.TaskEvent
import ru.itmo.analyticsservice.service.TaskEventService
import ru.itmo.apiobjects.kafka.model.TaskResponse
import java.time.LocalDateTime

@Service
class TaskResponseListener(private val taskEventService: TaskEventService) {
    private val logger = LoggerFactory.getLogger(TaskResponseListener::class.java)

    @KafkaListener(topics = ["task-responses"], groupId = "analytics-group")
    fun listen(response: TaskResponse) {
        logger.info("Received Task Response: $response")

        val taskEvent =
            TaskEvent(
                title = (response.title ?: "default title") + " W/ KAFKA #${response.correlationId}",
                description = (response.description ?: "default description") + "/w kafka #${(Math.random() * 1000000).toInt()}",
                taskId = response.taskId ?: -1,
                assignedTo = response.assignedTo ?: 0,
                dueDate = LocalDateTime.now(),
                priority = response.priority.toString(),
                projectId = response.projectId ?: -1,
                status = response.status.toString(),
            )

        taskEventService.saveTaskEvent(taskEvent)
    }
}
