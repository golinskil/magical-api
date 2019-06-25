package pl.inaczej.net.lukaszgolinski.magicalapi.service;

import org.springframework.stereotype.Service;
import pl.inaczej.net.lukaszgolinski.magicalapi.model.HoroscopeModel;
import pl.inaczej.net.lukaszgolinski.magicalapi.model.ServiceModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private final List<HoroscopeService> serviceList;

    public ApiServiceImpl(List<HoroscopeService> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public Flux<ServiceModel> listServices() {
        return Flux.fromIterable(serviceList);
    }

    @Override
    public Mono<HoroscopeModel> getDefaultHoroscope(String zodiac) {
        return serviceList.stream()
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No services found"))
                .getHoroscope(zodiac);
    }
}
