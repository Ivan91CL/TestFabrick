package com.fabrick.testfabrick.exception;

import com.fabrick.testfabrick.dto.ResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ErrorManagerTest {


    @Test
    public void generateErrorMessage() {
        ResponseEntity<ResponseDto> response = ErrorManager.generateErrorMessage(new CustomException());
        response = ErrorManager.generateErrorMessage(new CustomException(ERROR.DATE_ERR));

        assertNotNull(response);
    }
}