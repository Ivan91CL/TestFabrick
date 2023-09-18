package com.fabrick.testfabrick.model.getAccountTransactions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FabrickPayloadGetAccountTransactionsTest {

    @Test
    public void test(){
        List<Transaction> list = new ArrayList<>();

        FabrickPayloadGetAccountTransactions model1 = new FabrickPayloadGetAccountTransactions();
        model1.setList(list);

        FabrickPayloadGetAccountTransactions model2 = new FabrickPayloadGetAccountTransactions();
        model2.setList(list);

        assertEquals(model1, model2);
        assertEquals(model1.hashCode(), model2.hashCode());
    }

}