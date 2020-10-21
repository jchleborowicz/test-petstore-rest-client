package pl.jch.test.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.petstore.api")
public class SpringConfiguration {
    @Bean
    RestTemplate restTemplate() {
        final ClientHttpRequestFactory clientHttpRequestFactory =
                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());

        final RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        restTemplate.getInterceptors().add(new LoggingInterceptor());
        return restTemplate;
    }
}
