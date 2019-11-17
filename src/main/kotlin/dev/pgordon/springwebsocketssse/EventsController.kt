package dev.pgordon.springwebsocketssse

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
data class EventsController(val eventsRepository: ReactiveEventsRepository) {
    @GetMapping("/events/stream", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun feed(): Flux<Event> = eventsRepository.findAll()
}

data class Event(
    val payload: String,
    val number: Long
) {
    companion object {
        fun random(it: Long) = Event("test", it)
    }
}