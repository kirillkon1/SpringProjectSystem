@file:Suppress("ktlint:standard:no-wildcard-imports")

package ru.itmo.projectmanagementservice.model

import jakarta.persistence.*
import ru.itmo.apiobjects.domain.BaseEntity
import java.time.LocalDateTime

@Entity
@Table(name = "projects")
data class Project(
    val name: String,
    val description: String? = null,
    val location: String? = null,
    val startDate: LocalDateTime? = null,
    val endDate: LocalDateTime? = null,
    val budget: Double? = null,
) : BaseEntity()
