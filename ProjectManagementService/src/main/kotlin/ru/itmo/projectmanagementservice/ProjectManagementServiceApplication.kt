package ru.itmo.projectmanagementservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.retry.annotation.EnableRetry

@SpringBootApplication
@EnableRetry
class ProjectManagementServiceApplication

fun main(args: Array<String>) {
    runApplication<ProjectManagementServiceApplication>(*args)
}
