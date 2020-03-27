package net.bcneng.salarytrackerbe

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.extensions.Extension
import io.kotest.spring.SpringAutowireConstructorExtension
import io.kotest.spring.SpringListener

class ProjectConfig : AbstractProjectConfig() {
    override fun listeners() = listOf(SpringListener)
    override fun extensions(): List<Extension> = listOf(SpringAutowireConstructorExtension)
}
