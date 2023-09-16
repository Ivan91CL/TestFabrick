package com.fabrick.testfabrick.dto;

import lombok.Data;

@Data
public class GetAccountBalanceResponsePayload {

    private String date;
    private Number balance;
    private Number availableBalance;
    private String currency;
}
