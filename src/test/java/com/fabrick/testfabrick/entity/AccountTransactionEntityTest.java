package com.fabrick.testfabrick.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountTransactionEntityTest {

    @Test
    public void test(){
        Date date = new Date();
        TransactionTypeEntity transactionTypeEntity = new TransactionTypeEntity();
        transactionTypeEntity.setValue("");
        transactionTypeEntity.setEnumeration("");

        AccountTransactionEntity entity1 = new AccountTransactionEntity();
        entity1.setTransactionId("");
        entity1.setOperationId("");
        entity1.setAccountingDate(date);
        entity1.setValueDate(date);
        entity1.setTransactionType(transactionTypeEntity);
        entity1.setAmount(0.0f);
        entity1.setCurrency("");
        entity1.setDescription("");

        AccountTransactionEntity entity2 = new AccountTransactionEntity();
        entity2.setTransactionId("");
        entity2.setOperationId("");
        entity2.setAccountingDate(date);
        entity2.setValueDate(date);
        entity2.setTransactionType(transactionTypeEntity);
        entity2.setAmount(0.0f);
        entity2.setCurrency("");
        entity2.setDescription("");

        assertEquals(entity1, entity2);
        assertEquals(entity1.hashCode(), entity2.hashCode());
    }

}