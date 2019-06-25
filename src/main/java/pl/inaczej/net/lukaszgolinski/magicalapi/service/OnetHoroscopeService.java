package pl.inaczej.net.lukaszgolinski.magicalapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.inaczej.net.lukaszgolinski.magicalapi.exceptions.CustomWebClientException;
import pl.inaczej.net.lukaszgolinski.magicalapi.model.FeatureModel;
import pl.inaczej.net.lukaszgolinski.magicalapi.model.HoroscopeModel;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OnetHoroscopeService extends HoroscopeService {

    private final OnetWebClient client;

    public OnetHoroscopeService() {
        this.name = "onetService";
        this.client = new OnetWebClient();
        this.language = "PL";
        this.features = listAllFeatures();
    }

    @Override
    List<FeatureModel> listAllFeatures() {
        List<FeatureModel> featureModelList = new ArrayList<>();
        featureModelList.add(new FeatureModel("zodiac_dzienny"));
        featureModelList.add(new FeatureModel("other_feature"));
        return featureModelList;
    }

    @Override
    Mono<HoroscopeModel> getHoroscope(String zodiac) {
        return client
                .getHoroscope(zodiac)
                .map(OnetHoroscopeParser::parseOnetDocument)
                .onErrorResume(err -> Mono.error(new CustomWebClientException(err.getMessage())));
    }

}
