package todolist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@SpringBootApplication
class App

fun main() {
    SpringApplicationBuilder(App::class.java).run()
}