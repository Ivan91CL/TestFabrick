package com.fabrick.testfabrick.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
@Data
public class RestTemplateConfig {

    @Value("${api.key}")
    private String apiKey;
    @Value("${header.contentType}")
    private String contentType;
    @Value("${header.authSchema}")
    private String authSchema;
    @Value("${header.XTimeZone}")
    private String xTimeZone;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.setInterceptors(Collections.singletonList(new CustomClientHttpRequestInterceptor(apiKey, contentType, authSchema, xTimeZone)));

        return restTemplate;
    }
}
