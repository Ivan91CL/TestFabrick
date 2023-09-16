package com.fabrick.testfabrick.model;

import lombok.Data;

@Data
public class FabrickResponseGetAccountBalance extends FabrickResponse{

    private FabrickPayloadGetAccountBalance payload;
}
