package ru.itmo.usermanagementservice.service

import ru.itmo.usermanagementservice.dto.UserDTO

interface IUserService {
    fun getUserById(id: Long): UserDTO

    fun getAllUsers(): List<UserDTO>
}
