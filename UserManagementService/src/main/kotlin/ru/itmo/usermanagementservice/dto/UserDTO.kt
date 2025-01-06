package ru.itmo.usermanagementservice.dto

import java.io.Serializable
import java.time.LocalDateTime

/**
 * DTO for {@link ru.itmo.usermanagementservice.model.User}
 */
data class UserDTO(
    val id: Long,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
) : Serializable
