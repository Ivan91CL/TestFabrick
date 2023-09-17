package com.fabrick.testfabrick.model.createMoneyTransfer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CreditorTest {

    @Test
    public void test(){
        Creditor model1 = new Creditor();
        model1.setName("");
        model1.setAccount(null);

        Creditor model2 = new Creditor();
        model2.setName("");
        model2.setAccount(null);

        assertEquals(model1, model2);
        assertEquals(model1.hashCode(), model2.hashCode());
    }

}