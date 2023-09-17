package com.fabrick.testfabrick.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Data
public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    private String apiKey;
    private String contentType;
    private String authSchema;
    private String xTimeZone;

    public CustomClientHttpRequestInterceptor(String apiKey, String contentType, String authSchema, String xTimeZone) {
        super();
        this.apiKey = apiKey;
        this.contentType = contentType;
        this.authSchema = authSchema;
        this.xTimeZone = xTimeZone;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();

        headers.set("Content-Type", contentType);
        headers.set("Auth-Schema", authSchema);
        headers.set("Api-Key", apiKey);
        headers.set("X-Time-Zone", xTimeZone);

        return execution.execute(request, body);
    }
}
