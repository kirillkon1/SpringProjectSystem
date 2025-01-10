@file:Suppress("ktlint:standard:no-wildcard-imports")

package ru.itmo.usermanagementservice.controller

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.itmo.ru.itmo.apiobjects.dto.VerifyTokenDto
import ru.itmo.usermanagementservice.dto.AuthResponse
import ru.itmo.usermanagementservice.dto.LoginRequest
import ru.itmo.usermanagementservice.dto.UserDTO
import ru.itmo.usermanagementservice.service.impl.AuthService
import ru.itmo.usermanagementservice.dto.RegisterRequest as RegisterRequest

@RestController
@RequestMapping("/api/auth")
@Validated
class AuthController(
    private val authService: AuthService,
) {
    @PostMapping("/register")
    fun registerUser(
        @Valid @RequestBody registerRequest: RegisterRequest,
    ): ResponseEntity<UserDTO> {
        val userDTO = authService.registerUser(registerRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO)
    }

    @PostMapping("/login")
    fun loginUser(
        @Valid @RequestBody loginRequest: LoginRequest,
    ): ResponseEntity<AuthResponse> {
        val token = authService.authenticateUser(loginRequest.username, loginRequest.password)
        return ResponseEntity.ok(AuthResponse(token = token, username = loginRequest.username))
    }

    @PostMapping("/verify")
    fun loginUser(
        @Valid @RequestBody token: String,
    ): ResponseEntity<VerifyTokenDto> {
        return ResponseEntity.ok(authService.verifyToken(token))
    }
}
