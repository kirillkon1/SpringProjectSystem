@file:Suppress("ktlint:standard:no-wildcard-imports")

package ru.itmo.usermanagementservice.model

import jakarta.persistence.*
import ru.itmo.ru.itmo.apiobjects.domain.BaseEntity

@Entity
@Table(name = "users")
data class User(
    @Column(unique = true)
    val username: String,
    val password: String,
    @Column(unique = true)
    val email: String,
    val firstName: String,
    val lastName: String,
) : BaseEntity()
