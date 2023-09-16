package com.fabrick.testfabrick.assembler;

import com.fabrick.testfabrick.dto.createMoneyTransfer.CreateMoneyTransferRequestDto;
import com.fabrick.testfabrick.dto.createMoneyTransfer.CreateMoneyTransferResponseDto;
import com.fabrick.testfabrick.dto.createMoneyTransfer.CreateMoneyTransferResponsePayload;
import com.fabrick.testfabrick.dto.getAccountBalance.GetAccountBalanceResponseDto;
import com.fabrick.testfabrick.dto.getAccountBalance.GetAccountBalanceResponsePayload;
import com.fabrick.testfabrick.model.createMoneyTransfer.FabrickRequestCreateMoneyTransfer;
import com.fabrick.testfabrick.model.getAccountBalance.FabrickResponseGetAccountBalance;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class CreateMoneyTransferAssembler {

    public FabrickRequestCreateMoneyTransfer convertDtoToRequest(CreateMoneyTransferRequestDto dto){
        FabrickRequestCreateMoneyTransfer request = new FabrickRequestCreateMoneyTransfer();

        request.setCreditor(dto.getCreditor());
        request.setExecutionDate(new SimpleDateFormat("yyyy-MM-dd").format(dto.getExecutionDate()));
        request.setDescription(dto.getDescription());
        request.setAmount(dto.getAmount());
        request.setCurrency(dto.getCurrency());

        return request;
    }

    public CreateMoneyTransferResponseDto convertResponseToDto(ResponseEntity fabrickResponse){
        CreateMoneyTransferResponseDto responseDto = new CreateMoneyTransferResponseDto();
        CreateMoneyTransferResponsePayload payload = new CreateMoneyTransferResponsePayload();

        //conversione del payload

        responseDto.setPayload(payload);

        return responseDto;
    }
}
