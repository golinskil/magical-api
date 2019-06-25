package pl.inaczej.net.lukaszgolinski.magicalapi.service;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Component;
import pl.inaczej.net.lukaszgolinski.magicalapi.model.HoroscopeModel;
import reactor.core.publisher.Mono;

import java.time.LocalDate;


@ShellComponent
@Component
public class HoroscopeServiceImpl {


    public Mono<String> test() {
        return Mono.just(testInner());
    }


    public Mono<HoroscopeModel> testModel() {
        return Mono.just(testModelInner());
    }

    @ShellMethod("this a test method for horoscope model")
    private HoroscopeModel testModelInner() {
        return HoroscopeModel.builder()
                .source("onet.pl")
                .zodiac("Lybra")
                .forDate(LocalDate.now())
                .build();
    }

    @ShellMethod("this is just a test method")
    private String testInner() {
        return "test from horoscope service";
    }
}
