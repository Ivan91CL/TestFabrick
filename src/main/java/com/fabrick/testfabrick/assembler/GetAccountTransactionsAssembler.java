package com.fabrick.testfabrick.assembler;

import com.fabrick.testfabrick.dto.getAccountTransactions.GetAccountTransactionsRequestDto;
import com.fabrick.testfabrick.dto.getAccountTransactions.GetAccountTransactionsResponseDto;
import com.fabrick.testfabrick.dto.getAccountTransactions.GetAccountTransactionsResponsePayload;
import com.fabrick.testfabrick.exception.CustomException;
import com.fabrick.testfabrick.exception.ERROR;
import com.fabrick.testfabrick.model.getAccountTransactions.FabrickResponseGetAccountTransactions;
import com.fabrick.testfabrick.model.getAccountTransactions.Transaction;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class GetAccountTransactionsAssembler {

    public GetAccountTransactionsRequestDto convertRequestToDto(Long accountId, String fromAccountingDate, String toAccountingDate){
        GetAccountTransactionsRequestDto requestDto = new GetAccountTransactionsRequestDto();

        try {
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            inputDateFormat.setLenient(false);

            inputDateFormat.parse(fromAccountingDate);
            inputDateFormat.parse(toAccountingDate);
        }catch (ParseException e){
            throw new CustomException(ERROR.DATE_ERR);
        }

        requestDto.setAccountId(accountId);
        requestDto.setFromAccountingDate(fromAccountingDate);
        requestDto.setToAccountingDate(toAccountingDate);

        return requestDto;
    }

    public GetAccountTransactionsResponseDto convertResponseToDto(FabrickResponseGetAccountTransactions fabrickResponse){
        GetAccountTransactionsResponseDto responseDto = new GetAccountTransactionsResponseDto();
        GetAccountTransactionsResponsePayload payload = new GetAccountTransactionsResponsePayload();

        List<Transaction> responseList = fabrickResponse.getPayload().getList().stream()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        payload.setList(responseList);
        responseDto.setPayload(payload);

        return responseDto;
    }
}
