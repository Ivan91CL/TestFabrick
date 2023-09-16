package com.fabrick.testfabrick.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class ResponseDto {

    private String status = "OK";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ErrorDto error;

}
