package com.fabrick.testfabrick.dto.getAccountTransactions;

import lombok.Data;

@Data
public class GetAccountTransactionsRequestDto {

    private Long accountId;
    private String fromAccountingDate;
    private String toAccountingDate;
}
