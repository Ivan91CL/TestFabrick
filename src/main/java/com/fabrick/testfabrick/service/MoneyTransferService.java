package com.fabrick.testfabrick.service;

import com.fabrick.testfabrick.exception.CustomException;
import com.fabrick.testfabrick.model.createMoneyTransfer.FabrickRequestCreateMoneyTransfer;
import lombok.Data;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(MoneyTransferService.class);

    @Value("${endpoint.createMoneyTransferUrl}")
    private String createMoneyTransferUrl;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity createMoneyTransfer(FabrickRequestCreateMoneyTransfer request, Number accountId) {

        logger.info("[SERVICE] MoneyTransferService --- [METHOD] createMoneyTransfer");

        String uri = UriComponentsBuilder.fromHttpUrl(createMoneyTransferUrl)
                .buildAndExpand(accountId)
                .toUriString();

        try {
            //N.B. la classe di response non è stata implementata in quanto di grande dimensioni e non utilizzata
            return restTemplate.exchange(uri, HttpMethod.POST, new HttpEntity<>(request, null), ResponseEntity.class).getBody();
        } catch (Exception e) {
            if (e instanceof HttpClientErrorException) {
                logger.error("[ERROR] --- " + e.getMessage());
                logger.error("[STACKTRACE] --- " + ExceptionUtils.getStackTrace(e));
                throw new CustomException((HttpClientErrorException) e);
            } else {
                logger.error("[ERROR] --- " + e.getMessage());
                logger.error("[STACKTRACE] --- " + ExceptionUtils.getStackTrace(e));
                throw new CustomException();
            }
        }
    }
}
