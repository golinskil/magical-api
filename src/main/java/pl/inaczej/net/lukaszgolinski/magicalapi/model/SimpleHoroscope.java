package pl.inaczej.net.lukaszgolinski.magicalapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimpleHoroscope {
    private String title;
    private String content;
}
