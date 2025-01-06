package ru.itmo.usermanagementservice.mapper

import ru.itmo.usermanagementservice.dto.UserDTO
import ru.itmo.usermanagementservice.model.User

fun User.toDTO(): UserDTO {
    return UserDTO(
        id = this.id,
        username = this.username,
        email = this.email,
        firstName = this.firstName,
        lastName = this.lastName,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
    )
}
