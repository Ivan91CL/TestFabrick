package com.fabrick.testfabrick.service;

import com.fabrick.testfabrick.exception.CustomException;
import com.fabrick.testfabrick.model.createMoneyTransfer.FabrickRequestCreateMoneyTransfer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Data
public class MoneyTransferService {

    @Value("${endpoint.createMoneyTransferUrl}")
    private String createMoneyTransferUrl;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity createMoneyTransfer(FabrickRequestCreateMoneyTransfer request, Number accountId) {
        String uri = UriComponentsBuilder.fromHttpUrl(createMoneyTransferUrl)
                .buildAndExpand(accountId)
                .toUriString();

        try {
            //N.B. la classe di response non è stata implementata in quanto di grande dimensioni e non utilizzata
            return restTemplate.exchange(uri, HttpMethod.POST, new HttpEntity<>(request, null), ResponseEntity.class).getBody();
        } catch (Exception e) {
            if (e instanceof HttpClientErrorException) {
                throw new CustomException((HttpClientErrorException) e);
            } else {
                throw new CustomException();
            }
        }
    }
}
