package com.fabrick.testfabrick.service;

import com.fabrick.testfabrick.exception.CustomException;
import com.fabrick.testfabrick.model.getAccountBalance.FabrickResponseGetAccountBalance;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@Data
public class AccountService {

    @Value("${endpoint.getAccountBalanceUrl}")
    private String getAccountBalanceUrl;

    @Autowired
    private RestTemplate restTemplate;

    public FabrickResponseGetAccountBalance getAccountBalance(Long accountId){

        try {
            return restTemplate.exchange(getAccountBalanceUrl, HttpMethod.GET, null, FabrickResponseGetAccountBalance.class, accountId).getBody();
        }catch (Exception e){
            if(e instanceof HttpClientErrorException) {
                throw new CustomException((HttpClientErrorException) e);
            }
        }
        return null;
    }
}
