package ru.itmo.projectmanagementservice.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.itmo.projectmanagementservice.model.Project

@Repository
interface ProjectRepository : JpaRepository<Project, Long> {
    fun findByNameContainingIgnoreCase(name: String): List<Project>

    fun findByLocationContainingIgnoreCase(location: String): List<Project>

    fun findByBudgetGreaterThanEqual(budget: Double): List<Project>

    fun findByBudgetLessThanEqual(budget: Double): List<Project>
}
