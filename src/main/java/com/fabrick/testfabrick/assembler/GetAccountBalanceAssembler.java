package com.fabrick.testfabrick.assembler;

import com.fabrick.testfabrick.dto.getAccountBalance.GetAccountBalanceResponseDto;
import com.fabrick.testfabrick.dto.getAccountBalance.GetAccountBalanceResponsePayload;
import com.fabrick.testfabrick.model.getAccountBalance.FabrickResponseGetAccountBalance;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class GetAccountBalanceAssembler {

    public GetAccountBalanceResponseDto convertResponseToDto(FabrickResponseGetAccountBalance fabrickResponse){
        GetAccountBalanceResponseDto responseDto = new GetAccountBalanceResponseDto();
        GetAccountBalanceResponsePayload payload = new GetAccountBalanceResponsePayload();

        payload.setDate(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(fabrickResponse.getPayload().getDate()));
        payload.setBalance(fabrickResponse.getPayload().getBalance());
        payload.setAvailableBalance(fabrickResponse.getPayload().getAvailableBalance());
        payload.setCurrency(fabrickResponse.getPayload().getCurrency());

        responseDto.setPayload(payload);

        return responseDto;
    }
}
