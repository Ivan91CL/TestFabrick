package com.fabrick.testfabrick.model.getAccountTransactions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TransactionTest {

    @Test
    public void test(){
        TransactionType type = new TransactionType();
        Date date = new Date();

        Transaction model1 = new Transaction();
        model1.setTransactionId("");
        model1.setOperationId("");
        model1.setAccountingDate(date);
        model1.setValueDate(date);
        model1.setType(type);
        model1.setAmount(0);
        model1.setCurrency("");
        model1.setDescription("");

        Transaction model2 = new Transaction();
        model2.setTransactionId("");
        model2.setOperationId("");
        model2.setAccountingDate(date);
        model2.setValueDate(date);
        model2.setType(type);
        model2.setAmount(0);
        model2.setCurrency("");
        model2.setDescription("");

        assertEquals(model1, model2);
        assertEquals(model1.hashCode(), model2.hashCode());
    }

}