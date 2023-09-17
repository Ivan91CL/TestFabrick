package com.fabrick.testfabrick.model.createMoneyTransfer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FabrickRequestCreateMoneyTransferTest {

    @Test
    public void test(){
        FabrickRequestCreateMoneyTransfer model1 = new FabrickRequestCreateMoneyTransfer();
        model1.setCurrency("");
        model1.setCreditor(null);
        model1.setAmount(0);
        model1.setDescription("");
        model1.setExecutionDate("25-12-2023");

        FabrickRequestCreateMoneyTransfer model2 = new FabrickRequestCreateMoneyTransfer();
        model2.setCurrency("");
        model2.setCreditor(null);
        model2.setAmount(0);
        model2.setDescription("");
        model2.setExecutionDate("25-12-2023");

        assertEquals(model1, model2);
        assertEquals(model1.hashCode(), model2.hashCode());
    }

}