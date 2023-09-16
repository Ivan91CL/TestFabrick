package com.fabrick.testfabrick.dto.createMoneyTransfer;

import com.fabrick.testfabrick.model.createMoneyTransfer.Creditor;
import lombok.Data;

import java.util.Date;

@Data
public class CreateMoneyTransferRequestDto {

    private Number accountId;
    private Creditor creditor;
    private Date executionDate;
    private String description;
    private Number amount;
    private String currency;
}
