package pl.inaczej.net.lukaszgolinski.magicalapi.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import pl.inaczej.net.lukaszgolinski.magicalapi.model.HoroscopeModel;
import pl.inaczej.net.lukaszgolinski.magicalapi.model.SimpleHoroscope;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static pl.inaczej.net.lukaszgolinski.magicalapi.service.OnetHoroscopeConstants.MAGIA_ONET_URL;
import static pl.inaczej.net.lukaszgolinski.magicalapi.service.OnetHoroscopeConstants.ZODIAC_DZIENNY;

class OnetHoroscopeParser {

    static HoroscopeModel parseOnetDocument(String document) {
        if (document.equals("Error")) {
            return HoroscopeModel.builder().build();
        }

        Document parse = Jsoup.parse(document);
        Element detail = parse.getElementById("detail");

        List<SimpleHoroscope> horoscopeList = new ArrayList<>();
        for (Element h3 : detail.getElementsByTag("h3")) {
            horoscopeList.add(new SimpleHoroscope(h3.text(), h3.nextElementSibling().text()));
        }

        return HoroscopeModel.builder()
                .forDate(LocalDate.now())
                .source(MAGIA_ONET_URL + ZODIAC_DZIENNY)
                .horoscopeList(horoscopeList)
                .build();
    }
}
