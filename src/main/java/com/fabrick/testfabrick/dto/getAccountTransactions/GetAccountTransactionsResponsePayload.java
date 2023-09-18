package com.fabrick.testfabrick.dto.getAccountTransactions;

import com.fabrick.testfabrick.model.getAccountTransactions.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class GetAccountTransactionsResponsePayload {

    private List<Transaction> list;
}
