package net.bcneng.salarytrackerbe.infrastructure.http

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HealthIntegrationTest : StringSpec() {
    @LocalServerPort
    private var port = 0
    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    init {
        "health should return 200" {
            val response = restTemplate.getForEntity<String>("http://localhost:$port/health")

            response.statusCode shouldBe HttpStatus.OK
        }
    }
}
