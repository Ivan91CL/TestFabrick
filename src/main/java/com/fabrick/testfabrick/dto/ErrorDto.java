package com.fabrick.testfabrick.dto;

import lombok.Data;

@Data
public class ErrorDto {

    private String errorCode;
    private String message;

    public ErrorDto(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
