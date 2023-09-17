package com.fabrick.testfabrick.command;

import com.fabrick.testfabrick.service.MoneyTransferService;
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
public class CreateMoneyTransferCommandTest {

    @Autowired
    private CreateMoneyTransferCommand command;

    @MockBean
    private MoneyTransferService service;

    @Test
    public void test(){
        command = new CreateMoneyTransferCommand();
        CreateMoneyTransferCommand command1 = new CreateMoneyTransferCommand(null, 0);
        CreateMoneyTransferCommand command2 = new CreateMoneyTransferCommand(null, 0);

        command.getRequest();
        command.getAccountId();
        command.getMoneyTransferService();

        assertEquals(command1, command2);
        assertEquals(command1.hashCode(), command2.hashCode());
    }

    @Test
    public void execute() {
        when(service.createMoneyTransfer(any(), any())).thenReturn(new ResponseEntity(HttpStatus.OK));
        ResponseEntity response = command.execute();

        assertNotNull(response);
    }
}