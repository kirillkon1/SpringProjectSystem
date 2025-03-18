package ru.itmo.analyticsservice.config

import mu.KotlinLogging
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {}

@Component
class ContextPropertiesPrinter : ApplicationListener<ContextRefreshedEvent> {
    private companion object {
        @Suppress("ktlint:standard:property-naming")
        var DELIMITER = "-".repeat(64) + "\n"

        @Suppress("ktlint:standard:property-naming")
        var DOUBLE_DELIMITER = "=".repeat(64) + "\n"
    }

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        val env = event.applicationContext.environment as ConfigurableEnvironment

        val propertiesInfo =
            buildString {
                append("\n")
                append(DOUBLE_DELIMITER)
                append("AnalyticsService properties changed: \n")
                append(DOUBLE_DELIMITER)
                append("Application name ..............................${env.getProperty("spring.application.name")}\n")
                append("Service name ..................................${env.getProperty("spring.service.name")}\n")
                append("Version .......................................${env.getProperty("spring.service.version")}\n")
                append("Service port ..................................${env.getProperty("server.port")}\n")
                append("Active profiles ...............................${env.activeProfiles.contentToString()}\n")
                append(DELIMITER)
            }

        log.info { propertiesInfo }
    }
}
