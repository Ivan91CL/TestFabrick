package com.fabrick.testfabrick.assembler;

import com.fabrick.testfabrick.dto.createMoneyTransfer.CreateMoneyTransferRequestDto;
import com.fabrick.testfabrick.dto.createMoneyTransfer.CreateMoneyTransferResponseDto;
import com.fabrick.testfabrick.model.createMoneyTransfer.Creditor;
import com.fabrick.testfabrick.model.createMoneyTransfer.FabrickRequestCreateMoneyTransfer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CreateMoneyTransferAssemblerTest {

    @Autowired
    public CreateMoneyTransferAssembler assembler;

    @Test
    public void convertDtoToRequest() throws ParseException {
        CreateMoneyTransferRequestDto dto = new CreateMoneyTransferRequestDto();
        dto.setAccountId(12345678);
        dto.setCreditor(new Creditor());
        dto.setExecutionDate(new SimpleDateFormat("yyyy-MM-dd").parse("2023-12-25"));
        dto.setDescription("desc");
        dto.setAmount(100);
        dto.setCurrency("EUR");

        FabrickRequestCreateMoneyTransfer request = assembler.convertDtoToRequest(dto);

        assertEquals(dto.getCreditor(), request.getCreditor());
        assertEquals(dto.getExecutionDate(), new SimpleDateFormat("yyyy-MM-dd").parse(request.getExecutionDate()));
        assertEquals(dto.getDescription(), request.getDescription());
        assertEquals(dto.getAmount(), request.getAmount());
        assertEquals(dto.getCurrency(), request.getCurrency());
    }

    @Test
    public void convertResponseToDto() {
        ResponseEntity response = new ResponseEntity(HttpStatus.OK);

        CreateMoneyTransferResponseDto dto = assembler.convertResponseToDto(response);

        assertNotNull(dto);
    }
}