package ru.itmo.usermanagementservice.service

import ru.itmo.ru.itmo.apiobjects.dto.VerifyTokenDto
import ru.itmo.usermanagementservice.dto.RegisterRequest
import ru.itmo.usermanagementservice.dto.UserDTO

interface IAuthService {
    fun registerUser(registerRequest: RegisterRequest): UserDTO

    fun authenticateUser(username: String, password: String): String // Возвращает JWT

    fun verifyToken(token: String): VerifyTokenDto
}
