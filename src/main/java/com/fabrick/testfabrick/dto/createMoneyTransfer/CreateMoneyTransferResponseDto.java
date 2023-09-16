package com.fabrick.testfabrick.dto.createMoneyTransfer;

import com.fabrick.testfabrick.dto.ResponseDto;
import com.fabrick.testfabrick.dto.getAccountBalance.GetAccountBalanceResponsePayload;
import lombok.Data;

@Data
public class CreateMoneyTransferResponseDto extends ResponseDto {

    private CreateMoneyTransferResponsePayload payload;
}
