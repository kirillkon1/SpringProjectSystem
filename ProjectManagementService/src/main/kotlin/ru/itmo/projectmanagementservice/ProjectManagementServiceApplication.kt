package ru.itmo.projectmanagementservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProjectManagementServiceApplication

fun main(args: Array<String>) {
	runApplication<ProjectManagementServiceApplication>(*args)
}
