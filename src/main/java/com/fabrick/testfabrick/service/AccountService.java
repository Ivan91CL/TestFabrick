package com.fabrick.testfabrick.service;

import com.fabrick.testfabrick.controller.FabrickController;
import com.fabrick.testfabrick.dto.getAccountTransactions.GetAccountTransactionsRequestDto;
import com.fabrick.testfabrick.entity.AccountTransactionEntity;
import com.fabrick.testfabrick.exception.CustomException;
import com.fabrick.testfabrick.factory.AccountTransactionFactory;
import com.fabrick.testfabrick.model.getAccountBalance.FabrickResponseGetAccountBalance;
import com.fabrick.testfabrick.model.getAccountTransactions.FabrickResponseGetAccountTransactions;
import com.fabrick.testfabrick.model.getAccountTransactions.Transaction;
import com.fabrick.testfabrick.repository.AccountTransactionsRepository;
import com.fabrick.testfabrick.repository.TransactionTypesRepository;
import lombok.Data;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Data
public class AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Value("${endpoint.getAccountBalanceUrl}")
    private String getAccountBalanceUrl;
    @Value("${endpoint.getAccountTransactionsUrl}")
    private String getAccountTransactionsUrl;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;
    @Autowired
    private TransactionTypesRepository transactionTypesRepository;
    @Autowired
    private AccountTransactionFactory accountTransactionFactory;

    public FabrickResponseGetAccountBalance getAccountBalance(Number accountId){

        logger.info("[SERVICE] AccountService --- [METHOD] getAccountBalance");

        try {
            return restTemplate.exchange(getAccountBalanceUrl, HttpMethod.GET, null, FabrickResponseGetAccountBalance.class, accountId).getBody();
        }catch (Exception e){
            if(e instanceof HttpClientErrorException) {
                logger.error("[ERROR] --- " + e.getMessage());
                logger.error("[STACKTRACE] --- " + ExceptionUtils.getStackTrace(e));
                throw new CustomException((HttpClientErrorException) e);
            }else {
                logger.error("[ERROR] --- " + e.getMessage());
                logger.error("[STACKTRACE] --- " + ExceptionUtils.getStackTrace(e));
                throw new CustomException();
            }
        }
    }

    public FabrickResponseGetAccountTransactions getAccountTransactions(GetAccountTransactionsRequestDto dto){

        logger.info("[SERVICE] AccountService --- [METHOD] getAccountTransactions");

        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("accountId", dto.getAccountId().toString());

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(getAccountTransactionsUrl);
        uriBuilder.queryParam("fromAccountingDate", dto.getFromAccountingDate());
        uriBuilder.queryParam("toAccountingDate", dto.getToAccountingDate());
        URI uri = uriBuilder.buildAndExpand(pathParams).toUri();

        try {
            FabrickResponseGetAccountTransactions response = restTemplate.exchange(uri, HttpMethod.GET, null, FabrickResponseGetAccountTransactions.class).getBody();
            saveTransactionsToDb(response != null ? response.getPayload().getList() : null);
            return response;
        }catch (Exception e){
            if(e instanceof HttpClientErrorException) {
                logger.error("[ERROR] --- " + e.getMessage());
                logger.error("[STACKTRACE] --- " + ExceptionUtils.getStackTrace(e));
                throw new CustomException((HttpClientErrorException) e);
            }else {
                logger.error("[ERROR] --- " + e.getMessage());
                logger.error("[STACKTRACE] --- " + ExceptionUtils.getStackTrace(e));
                throw new CustomException();
            }
        }
    }

    private void saveTransactionsToDb(List<Transaction> transactionList){
        List<AccountTransactionEntity> entityList = accountTransactionFactory.toEntityList(transactionList);
        accountTransactionsRepository.saveAll(entityList);
    }
}
