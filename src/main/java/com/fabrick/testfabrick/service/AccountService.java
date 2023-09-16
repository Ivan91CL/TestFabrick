package com.fabrick.testfabrick.service;

import com.fabrick.testfabrick.model.FabrickResponseGetAccountBalance;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Data
public class AccountService {

    @Autowired
    private RestTemplate restTemplate;

    public FabrickResponseGetAccountBalance getAccountBalance(Long accountId){
        String uri = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/{accountId}/balance";

        FabrickResponseGetAccountBalance response = restTemplate.exchange(uri, HttpMethod.GET, null, FabrickResponseGetAccountBalance.class, accountId).getBody();

        return response;
    }
}
