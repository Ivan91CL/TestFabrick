package com.fabrick.testfabrick.model.getAccountTransactions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TransactionTypeTest {

    @Test
    public void test(){
        TransactionType model1 = new TransactionType();
        model1.setEnumeration("");
        model1.setValue("");

        TransactionType model2 = new TransactionType();
        model2.setEnumeration("");
        model2.setValue("");

        assertEquals(model1, model2);
        assertEquals(model1.hashCode(), model2.hashCode());
    }

}