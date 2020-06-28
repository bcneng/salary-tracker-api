package net.bcneng.salarytrackerbe

import io.kotest.core.spec.style.AnnotationSpec
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@WebFluxTest
class SalaryTrackerBeApplicationTests : AnnotationSpec() {

    @Test
    fun contextLoads() {
    }
}
