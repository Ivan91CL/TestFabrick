package com.fabrick.testfabrick.model.getAccountTransactions;

import lombok.Data;

import java.util.Date;

@Data
public class Transaction {

    private String transactionId;
    private String operationId;
    private Date accountingDate;
    private Date valueDate;
    private TransactionType type;
    private float amount;
    private String currency;
    private String description;
}
