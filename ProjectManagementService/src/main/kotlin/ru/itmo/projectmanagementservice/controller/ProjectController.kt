@file:Suppress("ktlint:standard:no-wildcard-imports")

package ru.itmo.projectmanagementservice.controller

import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.itmo.projectmanagementservice.dto.ProjectDTO
import ru.itmo.projectmanagementservice.model.Project
import ru.itmo.projectmanagementservice.service.impl.ProjectService

@RestController
@RequestMapping("/api/projects")
@Validated
class ProjectController(private val projectService: ProjectService) {
    @PostMapping
    fun createProject(
        @Valid @RequestBody dto: ProjectDTO,
    ): ResponseEntity<Project> {
        val createdProject = projectService.createProject(dto)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject)
    }

    @GetMapping("/{id}")
    fun getProjectById(
        @PathVariable @Min(1) id: Long,
    ): ResponseEntity<Project> {
        val project = projectService.getProjectById(id)
        return ResponseEntity.ok(project)
    }

    @PutMapping("/{id}")
    fun updateProject(
        @PathVariable @Min(1) id: Long,
        @Valid @RequestBody dto: ProjectDTO,
    ): ResponseEntity<Project> {
        val updatedProject = projectService.updateProject(id, dto)
        return ResponseEntity.ok(updatedProject)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteProject(
        @PathVariable @Min(1) id: Long,
    ) {
        projectService.deleteProject(id)
    }

    @GetMapping("/search/name")
    fun searchProjectsByName(
        @RequestParam name: String,
    ): ResponseEntity<List<Project>> {
        val projects = projectService.searchProjectsByName(name)
        return ResponseEntity.ok(projects)
    }

    @GetMapping("/search/location")
    fun searchProjectsByLocation(
        @RequestParam location: String,
    ): ResponseEntity<List<Project>> {
        val projects = projectService.searchProjectsByLocation(location)
        return ResponseEntity.ok(projects)
    }

    @GetMapping
    fun getAllProjects(): ResponseEntity<List<Project>> {
        val projects = projectService.getAllProjects()
        return ResponseEntity.ok(projects)
    }

    @GetMapping("/budget")
    fun getProjectsByBudgetRange(
        @RequestParam min: Double,
        @RequestParam max: Double,
    ): ResponseEntity<List<Project>> {
        val projects = projectService.getProjectsByBudgetRange(min, max)
        return ResponseEntity.ok(projects)
    }
}
