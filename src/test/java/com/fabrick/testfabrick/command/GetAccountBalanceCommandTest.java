package com.fabrick.testfabrick.command;

import com.fabrick.testfabrick.model.getAccountBalance.FabrickResponseGetAccountBalance;
import com.fabrick.testfabrick.service.AccountService;
import com.fabrick.testfabrick.service.MoneyTransferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GetAccountBalanceCommandTest {

    @Autowired
    private GetAccountBalanceCommand command;

    @MockBean
    private AccountService service;

    @Test
    public void test(){
        command = new GetAccountBalanceCommand();
        GetAccountBalanceCommand command1 = new GetAccountBalanceCommand(0);
        GetAccountBalanceCommand command2 = new GetAccountBalanceCommand(0);

        command.getAccountId();
        command.getAccountService();

        assertEquals(command1, command2);
        assertEquals(command1.hashCode(), command2.hashCode());
    }

    @Test
    public void execute() {
        when(service.getAccountBalance(any())).thenReturn(new FabrickResponseGetAccountBalance());
        FabrickResponseGetAccountBalance response = command.execute();

        assertNotNull(response);
    }
}