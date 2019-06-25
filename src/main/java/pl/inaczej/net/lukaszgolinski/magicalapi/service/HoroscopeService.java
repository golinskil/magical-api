package pl.inaczej.net.lukaszgolinski.magicalapi.service;

import pl.inaczej.net.lukaszgolinski.magicalapi.model.FeatureModel;
import pl.inaczej.net.lukaszgolinski.magicalapi.model.HoroscopeModel;
import pl.inaczej.net.lukaszgolinski.magicalapi.model.ServiceModel;
import reactor.core.publisher.Mono;

import java.util.List;

public abstract class HoroscopeService extends ServiceModel {

    abstract List<FeatureModel> listAllFeatures();

    abstract Mono<HoroscopeModel> getHoroscope(String zodiac);

}
