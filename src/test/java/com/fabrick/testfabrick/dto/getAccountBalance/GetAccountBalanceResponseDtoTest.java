package com.fabrick.testfabrick.dto.getAccountBalance;

import com.fabrick.testfabrick.dto.ErrorDto;
import com.fabrick.testfabrick.dto.createMoneyTransfer.CreateMoneyTransferResponseDto;
import com.fabrick.testfabrick.dto.createMoneyTransfer.CreateMoneyTransferResponsePayload;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GetAccountBalanceResponseDtoTest {

    @Test
    public void test(){
        GetAccountBalanceResponseDto dto1 = new GetAccountBalanceResponseDto();
        dto1.setStatus("");
        dto1.setError(new ErrorDto("", ""));
        dto1.setPayload(new GetAccountBalanceResponsePayload());

        GetAccountBalanceResponseDto dto2 = new GetAccountBalanceResponseDto();
        dto2.setStatus("");
        dto2.setError(new ErrorDto("", ""));
        dto2.setPayload(new GetAccountBalanceResponsePayload());

        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

}