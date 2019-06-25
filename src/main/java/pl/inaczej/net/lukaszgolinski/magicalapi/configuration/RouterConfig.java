package pl.inaczej.net.lukaszgolinski.magicalapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import pl.inaczej.net.lukaszgolinski.magicalapi.handlers.HoroscopeHandler;
import pl.inaczej.net.lukaszgolinski.magicalapi.handlers.ServicesHandler;

import java.net.URI;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterConfig {

    private final PropertiesConfig propertiesConfig;

    public RouterConfig(PropertiesConfig propertiesConfig) {
        this.propertiesConfig = propertiesConfig;
    }

    @Bean
    public RouterFunction<ServerResponse> route(ServicesHandler servicesHandler, HoroscopeHandler horoscopeHandler) {
        return RouterFunctions
                .route(GET("/"), req -> ServerResponse.temporaryRedirect(URI.create(propertiesConfig.getHomepageUrl())).build())
                .andRoute(GET("/services"), servicesHandler::listServices)
                .andRoute(GET("/horoscope/{zodiac}").and(accept(MediaType.APPLICATION_JSON)), horoscopeHandler::testModel)
                ;
    }


}
