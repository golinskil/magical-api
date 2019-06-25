package pl.inaczej.net.lukaszgolinski.magicalapi.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import pl.inaczej.net.lukaszgolinski.magicalapi.exceptions.CustomWebClientException;
import reactor.core.publisher.Mono;

import static pl.inaczej.net.lukaszgolinski.magicalapi.service.OnetHoroscopeConstants.*;

class OnetWebClient {

    private WebClient client = WebClient.builder()
            .baseUrl(MAGIA_ONET_URL)
            .build();

    Mono<String> getHoroscope(String zodiac) {
        return client.get()
                .uri(ZODIAC_DZIENNY + DELIMETER + zodiac)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->
                        Mono.error(new CustomWebClientException())
                )
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->
                        Mono.error(new CustomWebClientException())
                )
                .bodyToMono(String.class);
    }
}
