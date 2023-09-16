package com.fabrick.testfabrick.exception;

import lombok.Data;
import org.springframework.web.client.HttpClientErrorException;

@Data
public class CustomException extends RuntimeException {

    private String errorCode;
    private String message;

    public CustomException(HttpClientErrorException e) {
        super();
        if (e.getMessage().contains("REQ")) {
            this.errorCode = ERROR.REQ_ERR.getCode();
            this.message = ERROR.REQ_ERR.getMessage();
        } else if (e.getMessage().contains("CUS")) {
            this.errorCode = ERROR.REQ_ERR.getCode();
            this.message = ERROR.REQ_ERR.getMessage();
        } else if (e.getMessage().contains("BKN")) {
            this.errorCode = ERROR.REQ_ERR.getCode();
            this.message = ERROR.REQ_ERR.getMessage();
        } else if (e.getMessage().contains("PYM")) {
            this.errorCode = ERROR.REQ_ERR.getCode();
            this.message = ERROR.REQ_ERR.getMessage();
        } else {
            this.errorCode = ERROR.GEN_ERR.getCode();
            this.message = ERROR.GEN_ERR.getMessage();
        }
    }
}
