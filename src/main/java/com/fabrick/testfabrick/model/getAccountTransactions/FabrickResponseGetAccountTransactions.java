package com.fabrick.testfabrick.model.getAccountTransactions;

import com.fabrick.testfabrick.model.FabrickResponse;
import com.fabrick.testfabrick.model.getAccountBalance.FabrickPayloadGetAccountBalance;
import lombok.Data;

@Data
public class FabrickResponseGetAccountTransactions extends FabrickResponse {

    private FabrickPayloadGetAccountTransactions payload;
}
