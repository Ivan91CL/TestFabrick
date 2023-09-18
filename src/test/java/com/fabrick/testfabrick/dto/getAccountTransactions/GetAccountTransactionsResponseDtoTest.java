package com.fabrick.testfabrick.dto.getAccountTransactions;

import com.fabrick.testfabrick.dto.ErrorDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GetAccountTransactionsResponseDtoTest {

    @Test
    public void test(){
        GetAccountTransactionsResponsePayload payload = new GetAccountTransactionsResponsePayload();
        ErrorDto errorDto = new ErrorDto("", "");

        GetAccountTransactionsResponseDto dto1 = new GetAccountTransactionsResponseDto();
        dto1.setStatus("");
        dto1.setError(errorDto);
        dto1.setPayload(payload);

        GetAccountTransactionsResponseDto dto2 = new GetAccountTransactionsResponseDto();
        dto2.setStatus("");
        dto2.setError(errorDto);
        dto2.setPayload(payload);

        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

}