package com.fabrick.testfabrick.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ErrorDtoTest {

    @Test
    public void test(){
        ErrorDto dto1 = new ErrorDto("", "");
        ErrorDto dto2 = new ErrorDto("", "");

        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

}