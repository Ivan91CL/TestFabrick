package com.fabrick.testfabrick.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    @Value("${api.key}")
    private String apiKey;
    @Value("${header.contentType}")
    private String contentType;
    @Value("${header.authSchema}")
    private String authSchema;
    @Value("${header.XTimeZone}")
    private String XTimeZone;

    public CustomClientHttpRequestInterceptor() {
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();

        headers.set("Content-Type", contentType);
        headers.set("Auth-Schema", authSchema);
        headers.set("Api-Key", apiKey);
        headers.set("X-Time-Zone", XTimeZone);

        return execution.execute(request, body);
    }
}
