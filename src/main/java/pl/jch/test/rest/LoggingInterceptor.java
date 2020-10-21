package pl.jch.test.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import static java.util.stream.Collectors.joining;

@Slf4j
public class LoggingInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        log.info("Request body: {}", new String(body, StandardCharsets.UTF_8));

        final ClientHttpResponse response = execution.execute(request, body);

        final InputStreamReader responseReader = new InputStreamReader(response.getBody(), StandardCharsets.UTF_8);

        log.info(new BufferedReader(responseReader).lines().collect(joining("\n")));

        return response;
    }
}
