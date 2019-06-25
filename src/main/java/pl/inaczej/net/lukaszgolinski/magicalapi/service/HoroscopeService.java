package pl.inaczej.net.lukaszgolinski.magicalapi.service;

import pl.inaczej.net.lukaszgolinski.magicalapi.model.HoroscopeModel;
import reactor.core.publisher.Mono;

public interface HoroscopeService {
    Mono<HoroscopeModel> getHoroscope(String zodiac);
}
