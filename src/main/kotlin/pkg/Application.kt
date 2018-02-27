package pkg

import com.natpryce.konfig.*
import mu.KotlinLogging
import org.jetbrains.exposed.sql.Table
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
class Application



object server : PropertyGroup() {
    val port by intType
    val host by stringType
}

private val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {

    // val test = Application::javaClass.javaClass.classLoader.getResource("application.properties")

    // val path = args[0]

    // val path2 = System.getProperty("user.dir")

//    val config = systemProperties() overriding
//            EnvironmentVariables() overriding
//            ConfigurationProperties.fromResource(path2 + "/resources/application.properties")       //     ConfigurationProperties.fromResource(test.path)


//    logger.info { config.get(server.port) }
//    logger.info { config.get(server.host) }

    logger.info { "---------------------------------------------"  }


    SpringApplication.run(Application::class.java, *args)
}