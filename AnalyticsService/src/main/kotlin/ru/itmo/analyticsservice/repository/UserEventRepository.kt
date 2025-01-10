package ru.itmo.analyticsservice.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.itmo.analyticsservice.model.UserEvent

@Repository
interface UserEventRepository : JpaRepository<UserEvent, Long> {
    fun findByUserId(userId: Long): UserEvent?
}
