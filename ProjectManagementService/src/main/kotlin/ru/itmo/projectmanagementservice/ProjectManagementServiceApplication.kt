package ru.itmo.projectmanagementservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.retry.annotation.EnableRetry

@SpringBootApplication
@EnableRetry
@EnableDiscoveryClient
class ProjectManagementServiceApplication

fun main(args: Array<String>) {
    runApplication<ProjectManagementServiceApplication>(*args)
}
