package ru.itmo.projectmanagementservice.service.impl

import org.springframework.stereotype.Service
import ru.itmo.projectmanagementservice.dto.ProjectDTO
import ru.itmo.projectmanagementservice.model.Project
import ru.itmo.projectmanagementservice.repository.ProjectRepository
import ru.itmo.projectmanagementservice.service.IProjectService

@Service
class ProjectService(private val projectRepository: ProjectRepository) : IProjectService {
    override fun createProject(dto: ProjectDTO): Project {
        val project =
            Project(
                name = dto.name!!,
                description = dto.description,
                location = dto.location,
                startDate = dto.startDate,
                endDate = dto.endDate,
                budget = dto.budget,
            )

        return projectRepository.save(project)
    }

    override fun getProjectById(id: Long): Project {
        return projectRepository.findById(id).orElseThrow {
            RuntimeException("Проект с id $id не найден")
        }
    }

    override fun updateProject(
        id: Long,
        dto: ProjectDTO,
    ): Project {
        val existingProject = getProjectById(id)
        val updatedProject =
            existingProject.copy(
                name = dto.name!!,
                description = dto.description,
                location = dto.location,
                startDate = dto.startDate,
                endDate = dto.endDate,
                budget = dto.budget,
            )
        return projectRepository.save(updatedProject)
    }

    override fun deleteProject(id: Long) {
        val project = getProjectById(id)
        projectRepository.delete(project)
    }

    override fun searchProjectsByName(name: String): List<Project> {
        return projectRepository.findByNameContainingIgnoreCase(name)
    }

    override fun searchProjectsByLocation(location: String): List<Project> {
        return projectRepository.findByLocationContainingIgnoreCase(location)
    }

    override fun getAllProjects(): List<Project> {
        return projectRepository.findAll()
    }

    override fun getProjectsByBudgetRange(
        minBudget: Double,
        maxBudget: Double,
    ): List<Project> {
        return projectRepository.findByBudgetGreaterThanEqual(minBudget)
            .filter { it.budget != null && it.budget!! <= maxBudget }
    }
}
