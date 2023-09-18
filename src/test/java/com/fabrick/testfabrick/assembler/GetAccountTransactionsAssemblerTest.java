package com.fabrick.testfabrick.assembler;

import com.fabrick.testfabrick.dto.getAccountTransactions.GetAccountTransactionsRequestDto;
import com.fabrick.testfabrick.dto.getAccountTransactions.GetAccountTransactionsResponseDto;
import com.fabrick.testfabrick.exception.CustomException;
import com.fabrick.testfabrick.model.getAccountTransactions.FabrickPayloadGetAccountTransactions;
import com.fabrick.testfabrick.model.getAccountTransactions.FabrickResponseGetAccountTransactions;
import com.fabrick.testfabrick.model.getAccountTransactions.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GetAccountTransactionsAssemblerTest {

    @Autowired
    private GetAccountTransactionsAssembler assembler;

    @Test
    public void convertRequestToDto() {
        Long accountId = 0L;
        String fromAccountingDate = "2023-12-25";
        String toAccountingDate = "2024-12-25";

        GetAccountTransactionsRequestDto requestDto = assembler.convertRequestToDto(accountId, fromAccountingDate, toAccountingDate);

        assertEquals(requestDto.getAccountId(), accountId);
        assertEquals(requestDto.getFromAccountingDate(), fromAccountingDate);
        assertEquals(requestDto.getToAccountingDate(), toAccountingDate);
    }

    @Test
    public void convertRequestToDtoParseException() {
        Long accountId = 0L;
        String fromAccountingDate = "2023-12-25";
        String toAccountingDate = "25-12-2024";

        assertThrows(CustomException.class, () -> {
            assembler.convertRequestToDto(accountId, fromAccountingDate, toAccountingDate);
        });
    }

    @Test
    public void convertResponseToDto() {
        FabrickResponseGetAccountTransactions fabrickResponse = new FabrickResponseGetAccountTransactions();
        FabrickPayloadGetAccountTransactions fabrickPayload = new FabrickPayloadGetAccountTransactions();
        Transaction transaction = new Transaction();
        transaction.setTransactionId("1234");

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);
        fabrickPayload.setList(transactionList);
        fabrickResponse.setPayload(fabrickPayload);

        GetAccountTransactionsResponseDto dto = assembler.convertResponseToDto(fabrickResponse);

        assertEquals(dto.getPayload().getList().get(0).getTransactionId(), fabrickResponse.getPayload().getList().get(0).getTransactionId());
    }
}