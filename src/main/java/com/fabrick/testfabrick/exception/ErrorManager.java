package com.fabrick.testfabrick.exception;

import com.fabrick.testfabrick.dto.ErrorDto;
import com.fabrick.testfabrick.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public class ErrorManager {

    public static ResponseEntity<ResponseDto> generateErrorMessage(CustomException e){
        ResponseDto dto = new ResponseDto();
        dto.setStatus("KO");
        dto.setError(new ErrorDto(e.getErrorCode(), e.getMessage()));

        if(dto.getError().getErrorCode().equals("GEN_ERR")){
            return ResponseEntity.internalServerError().body(dto);
        }
        return ResponseEntity.badRequest().body(dto);
    }
}
