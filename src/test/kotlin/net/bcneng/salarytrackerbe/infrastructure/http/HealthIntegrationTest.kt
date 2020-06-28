package net.bcneng.salarytrackerbe.infrastructure.http

import io.kotest.core.spec.style.StringSpec
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

@ExtendWith(SpringExtension::class)
@WebFluxTest
class HealthIntegrationTest : StringSpec() {
    @Autowired
    private lateinit var webTestClient: WebTestClient

    init {
        "health should return 200" {
            webTestClient.get()
                .uri("/health")
                .exchange()
                .expectStatus().isOk
        }
    }
}
