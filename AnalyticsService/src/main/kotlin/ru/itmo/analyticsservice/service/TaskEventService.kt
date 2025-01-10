package ru.itmo.analyticsservice.service

import org.springframework.stereotype.Service
import ru.itmo.analyticsservice.model.TaskEvent
import ru.itmo.analyticsservice.repository.TaskEventRepository

@Service
class TaskEventService(private val taskEventRepository: TaskEventRepository) {
    fun saveTaskEvent(taskEvent: TaskEvent): TaskEvent {
        return taskEventRepository.save(taskEvent)
    }

    fun getAllTaskEvents(): List<TaskEvent> {
        return taskEventRepository.findAll()
    }

    fun getTaskCountByStatus(): Map<String, Long> {
        return taskEventRepository.findAll()
            .groupingBy { it.status }
            .eachCount()
            .mapValues { it.value.toLong() }
    }

    fun getTaskCountByPriority(): Map<String, Long> {
        return taskEventRepository.findAll()
            .groupingBy { it.priority }
            .eachCount()
            .mapValues { it.value.toLong() }
    }
}
