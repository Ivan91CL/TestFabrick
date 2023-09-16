package com.fabrick.testfabrick.dto;

import lombok.Data;

@Data
public class GetAccountBalanceResponseDto extends ResponseDto{

    private GetAccountBalanceResponsePayload payload;
}
