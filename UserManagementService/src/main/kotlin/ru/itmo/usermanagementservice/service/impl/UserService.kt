package ru.itmo.usermanagementservice.service.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.itmo.usermanagementservice.dto.UserDTO
import ru.itmo.usermanagementservice.mapper.toDTO
import ru.itmo.usermanagementservice.repository.UserRepository
import ru.itmo.usermanagementservice.service.IUserService

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository,
) : IUserService {
    override fun getUserById(id: Long): UserDTO {
        val user =
            userRepository
                .findById(id)
                .orElseThrow { RuntimeException("Пользователь с id $id не найден") }
        return user.toDTO()
    }

    override fun getAllUsers(): List<UserDTO> {
        return userRepository.findAll().map { it.toDTO() }
    }
}
