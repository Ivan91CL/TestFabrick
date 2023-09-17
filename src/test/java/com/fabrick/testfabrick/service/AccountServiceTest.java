package com.fabrick.testfabrick.service;

import com.fabrick.testfabrick.exception.CustomException;
import com.fabrick.testfabrick.model.getAccountBalance.FabrickResponseGetAccountBalance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AccountServiceTest {


    private AccountService accountService = new AccountService();

    @MockBean
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup(){
        accountService.setRestTemplate(restTemplate);
        accountService.setGetAccountBalanceUrl("https://api.io/example/{accountId}");
    }

    @Test
    public void getAccountBalance() {
        when(restTemplate.exchange("https://api.io/example/{accountId}", HttpMethod.GET, null, FabrickResponseGetAccountBalance.class, 0))
                .thenReturn(new ResponseEntity<>(HttpStatus.OK));

        FabrickResponseGetAccountBalance response = accountService.getAccountBalance(0);

        assertNull(response);
    }

    @Test
    public void getAccountBalanceException() {
        when(restTemplate.exchange("https://api.io/example/{accountId}", HttpMethod.GET, null, FabrickResponseGetAccountBalance.class, 0))
                .thenThrow(new CustomException());

        assertThrows(CustomException.class, () -> {
            accountService.getAccountBalance(0);
        });
    }

    @Test
    public void getAccountBalanceHttpException() {
        when(restTemplate.exchange("https://api.io/example/{accountId}", HttpMethod.GET, null, FabrickResponseGetAccountBalance.class, 0))
                .thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));

        assertThrows(CustomException.class, () -> {
            accountService.getAccountBalance(0);
        });
    }
}