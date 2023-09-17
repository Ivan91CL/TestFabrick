package com.fabrick.testfabrick.model.getAccountBalance;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FabrickResponseGetAccountBalanceTest {

    @Test
    public void test(){
        FabrickResponseGetAccountBalance model1 = new FabrickResponseGetAccountBalance();
        model1.setPayload(null);
        model1.setStatus("");
        model1.setError(null);

        FabrickResponseGetAccountBalance model2 = new FabrickResponseGetAccountBalance();
        model2.setPayload(null);
        model2.setStatus("");
        model2.setError(null);

        assertEquals(model1, model2);
        assertEquals(model1.hashCode(), model2.hashCode());
    }

}