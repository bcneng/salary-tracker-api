package net.bcneng.salarytrackerbe.infrastructure.http

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Health {

    @GetMapping("/health")
    fun health() = ""
}