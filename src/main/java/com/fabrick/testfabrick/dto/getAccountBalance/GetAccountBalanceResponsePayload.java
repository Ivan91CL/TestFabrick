package com.fabrick.testfabrick.dto.getAccountBalance;

import lombok.Data;

@Data
public class GetAccountBalanceResponsePayload {

    private String date;
    private Number balance;
    private Number availableBalance;
    private String currency;
}
