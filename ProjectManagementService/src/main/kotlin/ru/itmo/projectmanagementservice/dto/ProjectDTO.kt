@file:Suppress("ktlint:standard:no-wildcard-imports")

package ru.itmo.projectmanagementservice.dto

import jakarta.validation.constraints.*
import java.io.Serializable
import java.time.LocalDateTime

/**
 * DTO for {@link ru.itmo.projectmanagementservice.model.Project}
 */
data class ProjectDTO(
    @field:NotBlank(message = "Название проекта не может быть пустым")
    val name: String? = null,
    @field:Size(message = "Описание не должно превышать 2000 символов", max = 2000)
    val description: String? = null,
    @field:NotBlank(message = "Локация проекта не может быть пустой")
    val location: String? = null,
    val startDate: LocalDateTime? = null,
    val endDate: LocalDateTime? = null,
    @field:Min(message = "Бюджет проекта должен быть неотрицательным числом", value = 0)
    val budget: Double? = null,
) : Serializable
