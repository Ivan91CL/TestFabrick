package com.fabrick.testfabrick.model.getAccountBalance;

import com.fabrick.testfabrick.model.FabrickResponse;
import com.fabrick.testfabrick.model.getAccountBalance.FabrickPayloadGetAccountBalance;
import lombok.Data;

@Data
public class FabrickResponseGetAccountBalance extends FabrickResponse {

    private FabrickPayloadGetAccountBalance payload;
}
