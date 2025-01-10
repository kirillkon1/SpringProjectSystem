package ru.itmo.analyticsservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.retry.annotation.EnableRetry

@SpringBootApplication
@EnableRetry
class AnalyticsServiceApplication

fun main(args: Array<String>) {
    runApplication<AnalyticsServiceApplication>(*args)
}
