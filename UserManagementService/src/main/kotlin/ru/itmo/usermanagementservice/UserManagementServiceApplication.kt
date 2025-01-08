package ru.itmo.usermanagementservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.retry.annotation.EnableRetry

@SpringBootApplication
@EnableRetry
class UserManagementServiceApplication

fun main(args: Array<String>) {
    runApplication<UserManagementServiceApplication>(*args)
}
