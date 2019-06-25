package pl.inaczej.net.lukaszgolinski.magicalapi.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class PropertiesConfig {

    @Value("${homepage.url}")
    private String homepageUrl;
}
