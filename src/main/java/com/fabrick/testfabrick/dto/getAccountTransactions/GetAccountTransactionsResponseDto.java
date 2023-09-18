package com.fabrick.testfabrick.dto.getAccountTransactions;

import com.fabrick.testfabrick.dto.ResponseDto;
import com.fabrick.testfabrick.dto.getAccountBalance.GetAccountBalanceResponsePayload;
import lombok.Data;

@Data
public class GetAccountTransactionsResponseDto extends ResponseDto {

    private GetAccountTransactionsResponsePayload payload;
}
