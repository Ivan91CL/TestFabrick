package com.fabrick.testfabrick.assembler;

import com.fabrick.testfabrick.dto.GetAccountBalanceResponseDto;
import com.fabrick.testfabrick.dto.GetAccountBalanceResponsePayload;
import com.fabrick.testfabrick.model.FabrickResponseGetAccountBalance;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class GetAccountBalanceResponseAssembler {

    public GetAccountBalanceResponseDto convertToDto(FabrickResponseGetAccountBalance fabrickResponse){
        GetAccountBalanceResponseDto responseDto = new GetAccountBalanceResponseDto();
        GetAccountBalanceResponsePayload payload = new GetAccountBalanceResponsePayload();

        payload.setDate(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(fabrickResponse.getPayload().getDate()));
        payload.setBalance(fabrickResponse.getPayload().getBalance());
        payload.setAvailableBalance(fabrickResponse.getPayload().getAvailableBalance());
        payload.setCurrency(fabrickResponse.getPayload().getCurrency());

        responseDto.setPayload(payload);
        responseDto.setStatus("OK");

        return responseDto;
    }
}
