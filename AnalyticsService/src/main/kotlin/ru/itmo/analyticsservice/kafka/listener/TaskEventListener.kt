package ru.itmo.analyticsservice.kafka.listener

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import ru.itmo.analyticsservice.model.TaskEvent
import ru.itmo.analyticsservice.repository.TaskEventRepository

@Service
class TaskEventListener(private val taskEventRepository: TaskEventRepository) {
    private val logger = LoggerFactory.getLogger(TaskEventListener::class.java)

    @KafkaListener(topics = ["task-events"], groupId = "analytics-group")
    fun listen(taskEvent: TaskEvent) {
        logger.info("Received Task Event: $taskEvent")
        taskEventRepository.save(taskEvent)
    }
}
