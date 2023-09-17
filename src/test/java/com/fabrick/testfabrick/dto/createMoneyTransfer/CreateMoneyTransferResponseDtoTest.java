package com.fabrick.testfabrick.dto.createMoneyTransfer;

import com.fabrick.testfabrick.dto.ErrorDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CreateMoneyTransferResponseDtoTest {

    @Test
    public void test(){
        CreateMoneyTransferResponseDto dto1 = new CreateMoneyTransferResponseDto();
        dto1.setStatus("");
        dto1.setError(new ErrorDto("", ""));
        dto1.setPayload(new CreateMoneyTransferResponsePayload());

        CreateMoneyTransferResponseDto dto2 = new CreateMoneyTransferResponseDto();
        dto2.setStatus("");
        dto2.setError(new ErrorDto("", ""));
        dto2.setPayload(new CreateMoneyTransferResponsePayload());

        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

}