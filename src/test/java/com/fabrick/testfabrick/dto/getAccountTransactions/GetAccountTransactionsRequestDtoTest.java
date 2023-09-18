package com.fabrick.testfabrick.dto.getAccountTransactions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GetAccountTransactionsRequestDtoTest {

    @Test
    public void test(){
        GetAccountTransactionsRequestDto dto1 = new GetAccountTransactionsRequestDto();
        dto1.setAccountId(0L);
        dto1.setToAccountingDate("");
        dto1.setFromAccountingDate("");

        GetAccountTransactionsRequestDto dto2 = new GetAccountTransactionsRequestDto();
        dto2.setAccountId(0L);
        dto2.setToAccountingDate("");
        dto2.setFromAccountingDate("");

        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }


}