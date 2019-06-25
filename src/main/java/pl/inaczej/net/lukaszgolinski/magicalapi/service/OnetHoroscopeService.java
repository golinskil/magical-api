package pl.inaczej.net.lukaszgolinski.magicalapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.inaczej.net.lukaszgolinski.magicalapi.exceptions.CustomWebClientException;
import pl.inaczej.net.lukaszgolinski.magicalapi.model.HoroscopeModel;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class OnetHoroscopeService implements HoroscopeService {

    private OnetWebClient client = new OnetWebClient();

    @Override
    public Mono<HoroscopeModel> getHoroscope(String zodiac) {
        return client
                .getHoroscope(zodiac)
                .map(OnetHoroscopeParser::parseOnetDocument)
                .onErrorResume(err -> Mono.error(new CustomWebClientException(err.getMessage())));
    }
}
