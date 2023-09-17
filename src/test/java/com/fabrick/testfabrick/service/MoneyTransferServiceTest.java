package com.fabrick.testfabrick.service;

import com.fabrick.testfabrick.exception.CustomException;
import com.fabrick.testfabrick.model.createMoneyTransfer.FabrickRequestCreateMoneyTransfer;
import com.fabrick.testfabrick.model.getAccountBalance.FabrickResponseGetAccountBalance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MoneyTransferServiceTest {

    private MoneyTransferService moneyTransferService = new MoneyTransferService();

    @MockBean
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup(){
        moneyTransferService.setRestTemplate(restTemplate);
        moneyTransferService.setCreateMoneyTransferUrl("https://api.io/example/{accountId}");
    }

    @Test
    public void createMoneyTransfer() {
        FabrickRequestCreateMoneyTransfer request = new FabrickRequestCreateMoneyTransfer();

        when(restTemplate.exchange("https://api.io/example/0", HttpMethod.POST, new HttpEntity<>(request, null), ResponseEntity.class))
                .thenReturn(new ResponseEntity<>(HttpStatus.OK));

        ResponseEntity response = moneyTransferService.createMoneyTransfer(request, 0);

        assertNull(response);
    }

    @Test
    public void createMoneyTransferException() {
        FabrickRequestCreateMoneyTransfer request = new FabrickRequestCreateMoneyTransfer();

        when(restTemplate.exchange("https://api.io/example/0", HttpMethod.POST, new HttpEntity<>(request, null), ResponseEntity.class))
                .thenThrow(new CustomException());

        assertThrows(CustomException.class, () -> {
            moneyTransferService.createMoneyTransfer(request,0);
        });
    }

    @Test
    public void createMoneyTransferHttpException() {
        FabrickRequestCreateMoneyTransfer request = new FabrickRequestCreateMoneyTransfer();

        when(restTemplate.exchange("https://api.io/example/0", HttpMethod.POST, new HttpEntity<>(request, null), ResponseEntity.class))
                .thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));

        assertThrows(CustomException.class, () -> {
            moneyTransferService.createMoneyTransfer(request,0);
        });
    }
}