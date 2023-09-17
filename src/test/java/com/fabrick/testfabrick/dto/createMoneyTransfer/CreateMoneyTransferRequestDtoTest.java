package com.fabrick.testfabrick.dto.createMoneyTransfer;

import com.fabrick.testfabrick.model.createMoneyTransfer.Creditor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CreateMoneyTransferRequestDtoTest {

    @Test
    public void test(){
        CreateMoneyTransferRequestDto dto1 = new CreateMoneyTransferRequestDto();
        dto1.setAccountId(0);
        dto1.setCreditor(new Creditor());
        dto1.setAmount(0);
        dto1.setCurrency("");
        dto1.setDescription("");
        dto1.setExecutionDate(null);

        CreateMoneyTransferRequestDto dto2 = new CreateMoneyTransferRequestDto();
        dto2.setAccountId(0);
        dto2.setCreditor(new Creditor());
        dto2.setAmount(0);
        dto2.setCurrency("");
        dto2.setDescription("");
        dto2.setExecutionDate(null);

        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }
}