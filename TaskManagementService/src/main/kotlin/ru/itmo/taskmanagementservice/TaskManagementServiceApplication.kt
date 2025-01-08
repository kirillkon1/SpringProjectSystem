package ru.itmo.taskmanagementservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.retry.annotation.EnableRetry

@SpringBootApplication
@EnableRetry
class TaskManagementServiceApplication

fun main(args: Array<String>) {
    runApplication<TaskManagementServiceApplication>(*args)
}
