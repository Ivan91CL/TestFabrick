package com.fabrick.testfabrick.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ResponseDtoTest {

    @Test
    public void test(){
        ResponseDto dto1 = new ResponseDto();
        dto1.setError(new ErrorDto("", ""));
        dto1.setStatus("");

        ResponseDto dto2 = new ResponseDto();
        dto2.setError(new ErrorDto("", ""));
        dto2.setStatus("");

        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

}