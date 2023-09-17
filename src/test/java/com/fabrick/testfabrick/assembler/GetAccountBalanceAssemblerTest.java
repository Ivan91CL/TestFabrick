package com.fabrick.testfabrick.assembler;

import com.fabrick.testfabrick.dto.getAccountBalance.GetAccountBalanceResponseDto;
import com.fabrick.testfabrick.model.getAccountBalance.FabrickPayloadGetAccountBalance;
import com.fabrick.testfabrick.model.getAccountBalance.FabrickResponseGetAccountBalance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GetAccountBalanceAssemblerTest {

    @Autowired
    private GetAccountBalanceAssembler assembler;

    @Test
    public void convertResponseToDto() throws ParseException {
        FabrickResponseGetAccountBalance response = new FabrickResponseGetAccountBalance();
        FabrickPayloadGetAccountBalance payload = new FabrickPayloadGetAccountBalance();
        payload.setDate(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("25/12/2023 00:00:00"));
        payload.setBalance(100);
        payload.setAvailableBalance(100);
        payload.setCurrency("EUR");

        response.setStatus("OK");
        response.setPayload(payload);

        GetAccountBalanceResponseDto dto = assembler.convertResponseToDto(response);

        assertEquals(response.getStatus(), dto.getStatus());
        assertEquals(response.getPayload().getDate(), new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dto.getPayload().getDate()));
        assertEquals(response.getPayload().getBalance(), dto.getPayload().getBalance());
        assertEquals(response.getPayload().getAvailableBalance(), dto.getPayload().getAvailableBalance());
        assertEquals(response.getPayload().getCurrency(), dto.getPayload().getCurrency());
    }
}