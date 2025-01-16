@file:Suppress("ktlint:standard:no-wildcard-imports")

package ru.itmo.analyticsservice.model

import jakarta.persistence.*
import ru.itmo.apiobjects.domain.BaseEntity
import java.time.LocalDateTime

@Entity
@Table(name = "user_analytics")
data class UserEvent(
    val userId: Long,
    val username: String,
    val email: String,
    val registrationDate: LocalDateTime,
    // Дополнительные поля для аналитики
    val lastLogin: LocalDateTime? = null,
) : BaseEntity()
