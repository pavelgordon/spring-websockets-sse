package dev.pgordon.springwebsocketssse

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringWebsocketsSseApplication

fun main(args: Array<String>) {
    runApplication<SpringWebsocketsSseApplication>(*args)
}
