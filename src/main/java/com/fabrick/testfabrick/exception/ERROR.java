package com.fabrick.testfabrick.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ERROR {

    GEN_ERR("GEN_ERR", "Errore Generico", HttpStatus.INTERNAL_SERVER_ERROR),
    DATE_ERR("DATE_ERR", "La data fornita è in un formato errato. Assicurarsi che il formato sia yyyy-MM-dd", HttpStatus.BAD_REQUEST);

    private String code;
    private String message;
    private HttpStatus status;
}
