package pkg

import com.natpryce.konfig.*
import com.natpryce.konfig.ConfigurationProperties.Companion.systemProperties
import mu.KotlinLogging
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

object server : PropertyGroup() {
    val port by intType
    val host by stringType
}

private val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {

    val config = systemProperties() overriding
            EnvironmentVariables() overriding
            ConfigurationProperties.fromResource("application.properties")

    logger.info { config.get(server.port) }
    logger.info { config.get(server.host) }

    logger.info { "---------------------------------------------"  }


    SpringApplication.run(Application::class.java, *args)
}