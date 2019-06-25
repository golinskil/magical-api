package pl.inaczej.net.lukaszgolinski.magicalapi.service;

import pl.inaczej.net.lukaszgolinski.magicalapi.model.HoroscopeModel;
import pl.inaczej.net.lukaszgolinski.magicalapi.model.ServiceModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ApiService {
    Flux<ServiceModel> listServices();

    Mono<HoroscopeModel> getDefaultHoroscope(String zodiac);
}
