package ru.itmo.taskmanagementservice.kafka.listener

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import ru.itmo.apiobjects.kafka.model.TaskRequest
import ru.itmo.apiobjects.kafka.model.TaskResponse
import ru.itmo.taskmanagementservice.kafka.service.TaskResponseService
import ru.itmo.taskmanagementservice.repository.TaskRepository
import kotlin.jvm.optionals.getOrNull

@Service
class TaskRequestListener(
    private val taskRepository: TaskRepository,
    private val taskResponseService: TaskResponseService,
) {
    private val logger = LoggerFactory.getLogger(TaskRequestListener::class.java)

    @KafkaListener(topics = ["task-requests"], groupId = "task-group")
    fun listen(request: TaskRequest) {
        logger.info("Received Task Request: $request")
        // Обработка запроса, например, получение задачи из базы данных
        val task =
            taskRepository.findById(request.taskId).getOrNull()

        if (task == null) {
            taskResponseService.sendTaskResponse(
                TaskResponse(correlationId = request.correlationId),
            )
            logger.info("Sent Empty Task Response!")
            return
        }

        // Создание ответа
        val response =
            TaskResponse(
                correlationId = request.correlationId,
                taskId = task.id,
                title = task.title,
                description = task.description ?: "",
                dueDate = task.dueDate.toString(),
                assignedTo = task.assignedTo,
                projectId = task.projectId,
                priority = task.priority.toString(),
                status = task.status.toString(),
                createdAt = task.createdAt.toString(),
                updatedAt = task.updatedAt.toString(),
            )

        // Отправка ответа
        taskResponseService.sendTaskResponse(response)
        logger.info("Sent Task Response: $response")
    }
}
