package com.fabrick.testfabrick.model;

import lombok.Data;

import java.util.List;

@Data
public abstract class FabrickResponse {

    private String status;
    private List<FabrickError> error;

}
