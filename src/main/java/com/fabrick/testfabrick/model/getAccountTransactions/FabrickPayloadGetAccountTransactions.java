package com.fabrick.testfabrick.model.getAccountTransactions;

import lombok.Data;

import java.util.List;

@Data
public class FabrickPayloadGetAccountTransactions {

    private List<Transaction> list;

}
