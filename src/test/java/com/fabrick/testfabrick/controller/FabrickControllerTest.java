package com.fabrick.testfabrick.controller;

import com.fabrick.testfabrick.assembler.CreateMoneyTransferAssembler;
import com.fabrick.testfabrick.assembler.GetAccountBalanceAssembler;
import com.fabrick.testfabrick.command.CreateMoneyTransferCommand;
import com.fabrick.testfabrick.command.GetAccountBalanceCommand;
import com.fabrick.testfabrick.dto.createMoneyTransfer.CreateMoneyTransferRequestDto;
import com.fabrick.testfabrick.dto.createMoneyTransfer.CreateMoneyTransferResponseDto;
import com.fabrick.testfabrick.dto.getAccountBalance.GetAccountBalanceResponseDto;
import com.fabrick.testfabrick.exception.CustomException;
import com.fabrick.testfabrick.model.createMoneyTransfer.FabrickRequestCreateMoneyTransfer;
import com.fabrick.testfabrick.model.getAccountBalance.FabrickResponseGetAccountBalance;
import com.fabrick.testfabrick.utils.JsonFileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.HttpClientErrorException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class FabrickControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApplicationContext applicationContext;
    @MockBean
    private GetAccountBalanceCommand getAccountBalanceCommand;
    @MockBean
    private CreateMoneyTransferCommand createMoneyTransferCommand;
    @MockBean
    private GetAccountBalanceAssembler getAccountBalanceAssembler;
    @MockBean
    private CreateMoneyTransferAssembler createMoneyTransferAssembler;

    @BeforeEach
    public void setup(){
        when(applicationContext.getBean(eq(GetAccountBalanceCommand.class), any())).thenReturn(getAccountBalanceCommand);
        when(getAccountBalanceAssembler.convertResponseToDto(any())).thenReturn(new GetAccountBalanceResponseDto());
        when(applicationContext.getBean(eq(CreateMoneyTransferCommand.class), any(), any())).thenReturn(createMoneyTransferCommand);
        when(createMoneyTransferAssembler.convertDtoToRequest(any())).thenReturn(new FabrickRequestCreateMoneyTransfer());
        when(createMoneyTransferAssembler.convertResponseToDto(any())).thenReturn(new CreateMoneyTransferResponseDto());
    }

    @Test
    public void getAccountBalance() throws Exception {
        when(getAccountBalanceCommand.execute()).thenReturn(new FabrickResponseGetAccountBalance());

        mockMvc.perform(MockMvcRequestBuilders.get("/fabrick/getAccountBalance?accountId={accountId}", 123456789)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().json(JsonFileReader.readJsonFileAsString("/response/OkResponse.json")));
    }

    @Test
    public void getAccountBalanceException() throws Exception {
        when(getAccountBalanceCommand.execute()).thenThrow(new CustomException());

        mockMvc.perform(MockMvcRequestBuilders.get("/fabrick/getAccountBalance?accountId={accountId}", 123456789)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().json(JsonFileReader.readJsonFileAsString("/response/KoResponse.json")));
    }

    @Test
    public void createMoneyTransfer() throws Exception{
        when(createMoneyTransferCommand.execute()).thenReturn(new ResponseEntity(HttpStatus.OK));

        mockMvc.perform(MockMvcRequestBuilders.post("/fabrick/createMoneyTransfer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonFileReader.readJsonFileAsString("/request/createMoneyTransferRequest.json")))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().json(JsonFileReader.readJsonFileAsString("/response/OkResponse.json")));
    }

    @Test
    public void createMoneyTransferException() throws Exception{
        when(createMoneyTransferCommand.execute()).thenThrow(new CustomException());

        mockMvc.perform(MockMvcRequestBuilders.post("/fabrick/createMoneyTransfer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonFileReader.readJsonFileAsString("/request/createMoneyTransferRequest.json")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(JsonFileReader.readJsonFileAsString("/response/KoResponse.json")));
    }
}