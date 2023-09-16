package com.fabrick.testfabrick.dto.getAccountBalance;

import com.fabrick.testfabrick.dto.ResponseDto;
import lombok.Data;

@Data
public class GetAccountBalanceResponseDto extends ResponseDto {

    private GetAccountBalanceResponsePayload payload;
}
