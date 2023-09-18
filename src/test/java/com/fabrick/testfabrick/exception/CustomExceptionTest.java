package com.fabrick.testfabrick.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomExceptionTest {


    @Test
    public void test() throws IOException {
        CustomException customException = new CustomException();
        customException = new CustomException(ERROR.GEN_ERR);

        HttpClientErrorException ex = new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        customException = new CustomException(ex);

        ex = new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, Files.readString(Path.of("src/test/resources/response/FabrickHttpKoResponseBlankCode.txt")));
        customException = new CustomException(ex);

        ex = new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, Files.readString(Path.of("src/test/resources/response/FabrickHttpKoResponse.txt")));
        CustomException customException1 = new CustomException(ex);
        CustomException customException2 = new CustomException(ex);

        assertEquals(customException1, customException2);
        assertEquals(customException1.hashCode(), customException2.hashCode());
    }

}