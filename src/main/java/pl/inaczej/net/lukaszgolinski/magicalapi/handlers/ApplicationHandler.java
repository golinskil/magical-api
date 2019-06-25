package pl.inaczej.net.lukaszgolinski.magicalapi.handlers;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class ApplicationHandler {

    public Mono<ServerResponse> index(ServerRequest req) {
        return ok().body(Mono.just("Welcome to horoscope API"), String.class);
    }
}
