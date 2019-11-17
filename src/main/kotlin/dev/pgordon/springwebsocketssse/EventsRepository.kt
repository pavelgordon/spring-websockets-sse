package dev.pgordon.springwebsocketssse

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.time.Duration

@Repository
class ReactiveEventsRepository {
    fun findAll(): Flux<Event> {
        //simulate data streaming every 10 second.
        return Flux.interval(Duration.ofSeconds(10))
            .onBackpressureDrop()
            .map { listOf(Event.random(it)) }
            .flatMapIterable<Event> { it }
    }
}