package pl.inaczej.net.lukaszgolinski.magicalapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import pl.inaczej.net.lukaszgolinski.magicalapi.handlers.ApplicationHandler;
import pl.inaczej.net.lukaszgolinski.magicalapi.handlers.HoroscopeHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class WebConfig {


    @Bean
    public RouterFunction<ServerResponse> route(ApplicationHandler applicationHandler, HoroscopeHandler horoscopeHandler) {
        return RouterFunctions
                .route(GET("/").and(accept(MediaType.APPLICATION_JSON)), applicationHandler::index)
                .andRoute(GET("/horoscope/{zodiac}").and(accept(MediaType.APPLICATION_JSON)), horoscopeHandler::testModel)
                ;
    }


}
