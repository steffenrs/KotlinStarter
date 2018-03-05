package pkg

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong


private val logger = KotlinLogging.logger {}


@RestController
class GreetingController(private val repo: DefaultUserRepository) {

    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) : Greeting {
        logger.info { "Greeting called, called before: {}"  }
        logger.info("Greeting called, num: {}", counter.get())
        return Greeting(counter.incrementAndGet(), "Hello, $name")
    }

    @GetMapping("/greeting/db")
    fun greetingDb() : List<User> {
        return repo.findAll()
    }

}