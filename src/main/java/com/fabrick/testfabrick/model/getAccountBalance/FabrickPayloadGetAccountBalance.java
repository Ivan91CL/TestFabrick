package com.fabrick.testfabrick.model.getAccountBalance;

import lombok.Data;

import java.util.Date;

@Data
public class FabrickPayloadGetAccountBalance {

    private Date date;
    private Number balance;
    private Number availableBalance;
    private String currency;

}
