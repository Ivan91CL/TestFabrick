package com.fabrick.testfabrick.model.createMoneyTransfer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountTest {

    @Test
    public void test(){
        Account model1 = new Account();
        model1.setAccountCode("");

        Account model2 = new Account();
        model2.setAccountCode("");

        assertEquals(model1, model2);
        assertEquals(model1.hashCode(), model2.hashCode());
    }

}