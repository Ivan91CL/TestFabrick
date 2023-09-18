package com.fabrick.testfabrick.factory;

import com.fabrick.testfabrick.entity.AccountTransactionEntity;
import com.fabrick.testfabrick.model.getAccountTransactions.Transaction;
import com.fabrick.testfabrick.model.getAccountTransactions.TransactionType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountTransactionFactoryTest {

    @Autowired
    private AccountTransactionFactory factory;

    @Test
    public void toEntityList() {
        List<Transaction> transactionList = new ArrayList<>();
        Transaction transaction = new Transaction();
        TransactionType type = new TransactionType();
        type.setEnumeration("");
        type.setEnumeration("");

        transaction.setTransactionId("");
        transaction.setType(type);

        transactionList.add(transaction);

        List<AccountTransactionEntity> accountTransactionEntityList = factory.toEntityList(transactionList);

        assertEquals(accountTransactionEntityList.get(0).getTransactionId(), transactionList.get(0).getTransactionId());
    }
}