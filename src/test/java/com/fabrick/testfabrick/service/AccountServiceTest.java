package com.fabrick.testfabrick.service;

import com.fabrick.testfabrick.dto.getAccountTransactions.GetAccountTransactionsRequestDto;
import com.fabrick.testfabrick.exception.CustomException;
import com.fabrick.testfabrick.factory.AccountTransactionFactory;
import com.fabrick.testfabrick.model.getAccountBalance.FabrickResponseGetAccountBalance;
import com.fabrick.testfabrick.model.getAccountTransactions.FabrickPayloadGetAccountTransactions;
import com.fabrick.testfabrick.model.getAccountTransactions.FabrickResponseGetAccountTransactions;
import com.fabrick.testfabrick.model.getAccountTransactions.Transaction;
import com.fabrick.testfabrick.model.getAccountTransactions.TransactionType;
import com.fabrick.testfabrick.repository.AccountTransactionsRepository;
import com.fabrick.testfabrick.repository.TransactionTypesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AccountServiceTest {


    private AccountService accountService = new AccountService();

    @MockBean
    private RestTemplate restTemplate;
    @MockBean
    private TransactionTypesRepository transactionTypesRepository;
    @MockBean
    private AccountTransactionsRepository accountTransactionsRepository;
    @MockBean
    private AccountTransactionFactory accountTransactionFactory;

    @BeforeEach
    public void setup(){
        accountService.setRestTemplate(restTemplate);
        accountService.setAccountTransactionFactory(accountTransactionFactory);
        accountService.setAccountTransactionsRepository(accountTransactionsRepository);
        accountService.setTransactionTypesRepository(transactionTypesRepository);
        accountService.setGetAccountBalanceUrl("https://api.io/example/{accountId}");
        accountService.setGetAccountTransactionsUrl("https://api.io/example/{accountId}");
    }

    @Test
    public void getAccountBalance() {
        ResponseEntity<FabrickResponseGetAccountBalance> responseEntity = new ResponseEntity<>(new FabrickResponseGetAccountBalance(), HttpStatus.OK);
        when(restTemplate.exchange("https://api.io/example/{accountId}", HttpMethod.GET, null, FabrickResponseGetAccountBalance.class, 0))
                .thenReturn(responseEntity);

        FabrickResponseGetAccountBalance response = accountService.getAccountBalance(0);

        assertNotNull(response);
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

    @Test
    public void getAccountTransactions() {
        ResponseEntity<FabrickResponseGetAccountTransactions> responseEntity = getFabrickResponseGetAccountTransactionsResponseEntity();
        when(restTemplate.exchange(any(URI.class), any(HttpMethod.class), any(), any(Class.class)))
                .thenReturn(responseEntity);
        when(accountTransactionFactory.toEntityList(any())).thenReturn(new ArrayList<>());
        when(transactionTypesRepository.saveAll(any())).thenReturn(new ArrayList<>());

        GetAccountTransactionsRequestDto dto = new GetAccountTransactionsRequestDto();
        dto.setAccountId(0L);
        dto.setFromAccountingDate("2019-01-01");
        dto.setToAccountingDate("2019-12-01");

        FabrickResponseGetAccountTransactions response = accountService.getAccountTransactions(dto);

        assertNotNull(response);
    }

    @Test
    public void getAccountTransactionsException() {
        when(restTemplate.exchange(any(URI.class), any(HttpMethod.class), any(), any(Class.class)))
                .thenThrow(new CustomException());
        when(accountTransactionFactory.toEntityList(any())).thenReturn(new ArrayList<>());
        when(transactionTypesRepository.saveAll(any())).thenReturn(new ArrayList<>());

        GetAccountTransactionsRequestDto dto = new GetAccountTransactionsRequestDto();
        dto.setAccountId(0L);
        dto.setFromAccountingDate("2019-01-01");
        dto.setToAccountingDate("2019-12-01");

        assertThrows(CustomException.class, () -> {
            accountService.getAccountTransactions(dto);
        });
    }

    @Test
    public void getAccountTransactionsHttpException() {
        when(restTemplate.exchange(any(URI.class), any(HttpMethod.class), any(), any(Class.class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));
        when(accountTransactionFactory.toEntityList(any())).thenReturn(new ArrayList<>());
        when(transactionTypesRepository.saveAll(any())).thenReturn(new ArrayList<>());

        GetAccountTransactionsRequestDto dto = new GetAccountTransactionsRequestDto();
        dto.setAccountId(0L);
        dto.setFromAccountingDate("2019-01-01");
        dto.setToAccountingDate("2019-12-01");

        assertThrows(CustomException.class, () -> {
            accountService.getAccountTransactions(dto);
        });
    }

    private static ResponseEntity<FabrickResponseGetAccountTransactions> getFabrickResponseGetAccountTransactionsResponseEntity() {
        FabrickResponseGetAccountTransactions fabrickResponse = new FabrickResponseGetAccountTransactions();
        FabrickPayloadGetAccountTransactions payload = new FabrickPayloadGetAccountTransactions();
        List<Transaction> transactionList = new ArrayList<>();
        Transaction transaction = new Transaction();
        transaction.setTransactionId("123");
        transactionList.add(transaction);
        payload.setList(transactionList);
        fabrickResponse.setPayload(payload);

        ResponseEntity<FabrickResponseGetAccountTransactions> responseEntity = new ResponseEntity<>(fabrickResponse, HttpStatus.OK);
        return responseEntity;
    }
}