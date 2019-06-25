package pl.inaczej.net.lukaszgolinski.magicalapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AvailableEndpointsTests {

    @Autowired
    private RouterFunction<ServerResponse> route;

    @Bean
    public WebTestClient webTestClient() {
        return WebTestClient.bindToRouterFunction(route).build();
    }

    @Test
    public void testPerformGetServices() {
        webTestClient().get().uri("/services")
                .exchange()
                .expectStatus()
                .isOk();
    }
}
