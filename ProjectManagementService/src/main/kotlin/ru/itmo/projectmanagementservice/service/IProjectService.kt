@file:Suppress("ktlint:standard:filename")

package ru.itmo.projectmanagementservice.service

import ru.itmo.projectmanagementservice.dto.ProjectDTO
import ru.itmo.projectmanagementservice.model.Project

/**
 * Интерфейс для управления проектами, предоставляющий операции CRUD и дополнительные функции поиска.
 */
interface IProjectService {
    /**
     * Создаёт новый проект.
     *
     * @param dto DTO-объект проекта, который необходимо создать.
     * @return созданный объект проекта.
     */
    fun createProject(dto: ProjectDTO): Project

    /**
     * Получает проект по его уникальному идентификатору.
     *
     * @param id уникальный идентификатор проекта.
     * @return объект проекта с указанным идентификатором.
     */
    fun getProjectById(id: Long): Project

    /**
     * Обновляет существующий проект по его идентификатору.
     *
     * @param id уникальный идентификатор проекта, который необходимо обновить.
     * @param dto DTO-объект проекта с обновлёнными данными.
     * @return обновлённый объект проекта.
     */
    fun updateProject(
        id: Long,
        dto: ProjectDTO,
    ): Project

    /**
     * Удаляет проект по его уникальному идентификатору.
     *
     * @param id уникальный идентификатор проекта, который необходимо удалить.
     */
    fun deleteProject(id: Long)

    /**
     * Ищет проекты по названию.
     *
     * @param name название проекта или его часть для поиска.
     * @return список проектов, соответствующих заданному названию.
     */
    fun searchProjectsByName(name: String): List<Project>

    /**
     * Ищет проекты по местоположению.
     *
     * @param location местоположение проекта или его часть для поиска.
     * @return список проектов, соответствующих заданному местоположению.
     */
    fun searchProjectsByLocation(location: String): List<Project>

    /**
     * Получает список всех проектов.
     *
     * @return список всех доступных проектов.
     */
    fun getAllProjects(): List<Project>

    /**
     * Получает проекты, попадающие в заданный диапазон бюджета.
     *
     * @param minBudget минимальный бюджет проекта.
     * @param maxBudget максимальный бюджет проекта.
     * @return список проектов, бюджет которых находится в указанном диапазоне.
     */
    fun getProjectsByBudgetRange(
        minBudget: Double,
        maxBudget: Double,
    ): List<Project>
}
