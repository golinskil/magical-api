package pl.inaczej.net.lukaszgolinski.magicalapi.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class HoroscopeModel {
    private String zodiac;
    private LocalDate forDate;
    private String source;
    private List<SimpleHoroscope> horoscopeList;
}
