package com.fabrick.testfabrick.model.getAccountTransactions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FabrickResponseGetAccountTransactionsTest {

    @Test
    public void test(){
        FabrickPayloadGetAccountTransactions payload = new FabrickPayloadGetAccountTransactions();

        FabrickResponseGetAccountTransactions model1 = new FabrickResponseGetAccountTransactions();
        model1.setPayload(payload);
        model1.setStatus("");

        FabrickResponseGetAccountTransactions model2 = new FabrickResponseGetAccountTransactions();
        model2.setPayload(payload);
        model2.setStatus("");

        assertEquals(model1, model2);
        assertEquals(model1.hashCode(), model2.hashCode());
    }

}