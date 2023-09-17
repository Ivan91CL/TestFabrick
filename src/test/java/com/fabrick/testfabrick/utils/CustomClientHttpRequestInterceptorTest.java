package com.fabrick.testfabrick.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomClientHttpRequestInterceptorTest {

    @Mock
    private HttpRequest request;
    @Mock
    private HttpHeaders headers;
    @Mock
    private ClientHttpRequestExecution execution;
    @Mock
    private ClientHttpResponse response;
    private CustomClientHttpRequestInterceptor interceptor;

    @BeforeEach
    public void setup() {
        interceptor = new CustomClientHttpRequestInterceptor("apiKey", "application/json", "S2S", "Europe/Rome");
    }

    @Test
    public void intercept() throws IOException {
        when(request.getHeaders()).thenReturn(headers);
        when(execution.execute(request, null)).thenReturn(response);

        interceptor.setApiKey("apiKey");
        interceptor.setAuthSchema("application/json");
        interceptor.setXTimeZone("S2S");
        interceptor.setContentType("Europe/Rome");
        interceptor.getApiKey();
        interceptor.getAuthSchema();
        interceptor.getXTimeZone();
        interceptor.getContentType();

        ClientHttpResponse result = interceptor.intercept(request, null, execution);

        assert(result == response);
    }
}