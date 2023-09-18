package com.fabrick.testfabrick.command;

import com.fabrick.testfabrick.dto.getAccountTransactions.GetAccountTransactionsRequestDto;
import com.fabrick.testfabrick.model.getAccountTransactions.FabrickResponseGetAccountTransactions;
import com.fabrick.testfabrick.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GetAccountTransactionsCommandTest {

    @Autowired
    private GetAccountTransactionsCommand command;

    @MockBean
    private AccountService service;

    @Test
    public void test(){
        command = new GetAccountTransactionsCommand();
        GetAccountTransactionsCommand command1 = new GetAccountTransactionsCommand(new GetAccountTransactionsRequestDto());
        GetAccountTransactionsCommand command2 = new GetAccountTransactionsCommand(new GetAccountTransactionsRequestDto());

        command.getDto();
        command.getAccountService();

        assertEquals(command1, command2);
        assertEquals(command1.hashCode(), command2.hashCode());
    }

    @Test
    public void execute() {
        when(service.getAccountTransactions(any())).thenReturn(new FabrickResponseGetAccountTransactions());
        FabrickResponseGetAccountTransactions response = command.execute();

        assertNotNull(response);
    }
}