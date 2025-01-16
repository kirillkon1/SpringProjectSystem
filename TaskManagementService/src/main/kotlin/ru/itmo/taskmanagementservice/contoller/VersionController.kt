package ru.itmo.taskmanagementservice.contoller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/tasks/version")
class VersionController {
    @GetMapping
    fun getVersion(): String = "1.0.0"
}
