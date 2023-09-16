package com.fabrick.testfabrick.model.createMoneyTransfer;

import lombok.Data;

@Data
public class FabrickRequestCreateMoneyTransfer {

    private Creditor creditor;
    private String executionDate;
    private String description;
    private Number amount;
    private String currency;
}
