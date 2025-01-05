package ru.itmo.taskmanagementservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaskManagementServiceApplication

fun main(args: Array<String>) {
    runApplication<TaskManagementServiceApplication>(*args)
}
