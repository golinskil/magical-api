package pl.inaczej.net.lukaszgolinski.magicalapi.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pl.inaczej.net.lukaszgolinski.magicalapi.service.ApiService;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class HoroscopeHandler {

    private final ApiService apiService;

    public HoroscopeHandler(ApiService apiService) {
        this.apiService = apiService;
    }


    public Mono<ServerResponse> testModel(ServerRequest req) {

        return apiService.getDefaultHoroscope(req.pathVariable("zodiac"))
                .flatMap(s -> ServerResponse.ok()
                        .syncBody(s))
                .doOnError(err -> System.out.print("--------------------->dupa"))
                .onErrorResume(e -> Mono.just("Error " + e.getMessage())
                        .flatMap(s -> ServerResponse.ok()
                                .syncBody(s)));

//        return ok()
//                .body(horoscopeService.getHoroscope(req.pathVariable("zodiac")), HoroscopeModel.class)
//                .doOnError(err -> System.out.print("--------------------->dupa"));


    }

}
