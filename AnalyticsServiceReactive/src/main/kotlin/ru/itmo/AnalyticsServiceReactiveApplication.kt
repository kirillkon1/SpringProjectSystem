package ru.itmo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AnalyticsServiceReactiveApplication

fun main(args: Array<String>) {
	runApplication<AnalyticsServiceReactiveApplication>(*args)
}
