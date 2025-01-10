package ru.itmo.usermanagementservice.service.impl

import io.jsonwebtoken.JwtException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import ru.itmo.ru.itmo.apiobjects.dto.VerifyTokenDto
import ru.itmo.usermanagementservice.dto.RegisterRequest
import ru.itmo.usermanagementservice.dto.UserDTO
import ru.itmo.usermanagementservice.mapper.toDTO
import ru.itmo.usermanagementservice.model.User
import ru.itmo.usermanagementservice.repository.UserRepository
import ru.itmo.usermanagementservice.security.JwtTokenProvider
import ru.itmo.usermanagementservice.service.IAuthService

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider,
) : IAuthService {
    override fun registerUser(registerRequest: RegisterRequest): UserDTO {
        if (userRepository.existsByUsername(registerRequest.username)) {
            throw RuntimeException("Имя пользователя уже занято")
        }

        if (userRepository.existsByEmail(registerRequest.email)) {
            throw RuntimeException("Электронная почта уже используется")
        }

        val user =
            User(
                username = registerRequest.username,
                password = passwordEncoder.encode(registerRequest.password),
                email = registerRequest.email,
                firstName = registerRequest.firstName,
                lastName = registerRequest.lastName,
            )

        val savedUser = userRepository.save(user)
        return savedUser.toDTO()
    }

    override fun authenticateUser(
        username: String,
        password: String,
    ): String {
        val user =
            userRepository.findByUsername(username)
                .orElseThrow { UsernameNotFoundException("Пользователь $username не найден") }

        if (!passwordEncoder.matches(password, user.password)) {
            throw RuntimeException("Неверный пароль")
        }

        return jwtTokenProvider.generateToken(user.username)
    }

    override fun verifyToken(token: String): VerifyTokenDto {
        val response = VerifyTokenDto(token = token)

        try {
            val status = jwtTokenProvider.validateToken(token)

            if (!status) {
                throw JwtException("Невалидный токен!")
            }
            response.verifyStatus = true
            response.userName = jwtTokenProvider.getUsernameFromToken(token)
        } catch (e: Exception) {
            response.details = e.message
        }

        return response
    }
}
