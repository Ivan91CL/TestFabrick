package com.fabrick.testfabrick.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ERROR {

    GEN_ERR("GEN_ERR", "Generic Error", HttpStatus.INTERNAL_SERVER_ERROR),
    REQ_ERR("REQ_ERR", "Missing parameters or wrong parameter format in request", HttpStatus.BAD_REQUEST),
    CUS_ERR("CUS_ERR", "Application-level error related to Customer Information APIs", HttpStatus.INTERNAL_SERVER_ERROR),
    BKN_ERR("BKN_ERR", "Application-level error related to Banking APIs", HttpStatus.INTERNAL_SERVER_ERROR),
    PYM_ERR("PYM_ERR", "Application-level error related to Payments APIs", HttpStatus.INTERNAL_SERVER_ERROR);

    private String code;
    private String message;
    private HttpStatus status;
}
