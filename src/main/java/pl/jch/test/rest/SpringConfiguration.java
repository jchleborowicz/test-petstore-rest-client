package pl.jch.test.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.petstore.api")
public class SpringConfiguration {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
