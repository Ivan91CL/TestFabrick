package com.fabrick.testfabrick.model;

import lombok.Data;

@Data
public class FabrickError {

    private String code;
    private String description;
    private String params;
}
