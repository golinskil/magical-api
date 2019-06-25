package pl.inaczej.net.lukaszgolinski.magicalapi.handlers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pl.inaczej.net.lukaszgolinski.magicalapi.model.ServiceModel;
import pl.inaczej.net.lukaszgolinski.magicalapi.service.ApiService;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@Slf4j
public class ServicesHandler {


    private final ApiService apiService;

    public ServicesHandler(ApiService apiService) {
        this.apiService = apiService;
    }

    public Mono<ServerResponse> listServices(ServerRequest req) {
        apiService.listServices().subscribe(System.out::println);

        return ok()
                .body(apiService.listServices(), ServiceModel.class);
    }
}
