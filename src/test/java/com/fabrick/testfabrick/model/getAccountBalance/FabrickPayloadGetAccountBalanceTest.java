package com.fabrick.testfabrick.model.getAccountBalance;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FabrickPayloadGetAccountBalanceTest {

    @Test
    public void test(){
        FabrickPayloadGetAccountBalance model1 = new FabrickPayloadGetAccountBalance();
        model1.setBalance(0);
        model1.setAvailableBalance(0);
        model1.setCurrency("");
        model1.setDate(null);

        FabrickPayloadGetAccountBalance model2 = new FabrickPayloadGetAccountBalance();
        model2.setBalance(0);
        model2.setAvailableBalance(0);
        model2.setCurrency("");
        model2.setDate(null);

        assertEquals(model1, model2);
        assertEquals(model1.hashCode(), model2.hashCode());
    }

}