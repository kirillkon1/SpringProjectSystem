package ru.itmo.taskmanagementservice.service

import ru.itmo.taskmanagementservice.dto.TaskDTO
import ru.itmo.taskmanagementservice.model.Task
import ru.itmo.taskmanagementservice.model.TaskPriority
import ru.itmo.taskmanagementservice.model.TaskStatus

/**
 * Интерфейс, представляющий сервисный слой для управления задачами.
 */
interface ITaskService {
    /**
     * Создает новую задачу.
     *
     * @param dto DTO задача, которую нужно создать
     * @return созданная задача
     */
    fun createTask(dto: TaskDTO): Task

    /**
     * Получает задачу по ее уникальному идентификатору.
     *
     * @param id уникальный идентификатор задачи
     * @return задача с указанным идентификатором
     */
    fun getTaskById(id: Long): Task

    /**
     * Обновляет существующую задачу по ее уникальному идентификатору.
     *
     * @param id уникальный идентификатор задачи, которую нужно обновить
     * @param dto DTO задачи с обновленными данными
     * @return обновленная задача
     */
    fun updateTask(
        id: Long,
        dto: TaskDTO,
    ): Task

    /**
     * Удаляет задачу по ее уникальному идентификатору.
     *
     * @param id уникальный идентификатор задачи, которую нужно удалить
     */
    fun deleteTask(id: Long)

    /**
     * Ищет задачи по их названию.
     *
     * @param title название задач для поиска
     * @return список задач, соответствующих указанному названию
     */
    fun searchTasks(title: String): List<Task>

    /**
     * Получает все задачи.
     *
     * @return список всех задач
     */
    fun getAllTasks(): List<Task>

    /**
     * Получает задачи по их статусу.
     *
     * @param status статус задач для выборки
     * @return список задач с указанным статусом
     */
    fun getTasksByStatus(status: TaskStatus): List<Task>

    /**
     * Получает задачи по их приоритету.
     *
     * @param priority приоритет задач для выборки
     * @return список задач с указанным приоритетом
     */
    fun getTasksByPriority(priority: TaskPriority): List<Task>

    /**
     * Получает задачи, назначенные на конкретного пользователя.
     *
     * @param userId идентификатор пользователя, на которого назначены задачи
     * @return список задач, назначенных на указанного пользователя
     */
    fun getTasksByAssignedUser(userId: Long): List<Task>

    /**
     * Получает задачи, связанные с определенным проектом.
     *
     * @param projectId идентификатор проекта
     * @return список задач, связанных с указанным проектом
     */
    fun getTasksByProject(projectId: Long): List<Task>
}
