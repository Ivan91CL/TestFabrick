package com.fabrick.testfabrick.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ERRORTest {

    @Test
    public void test(){
        assertEquals(2, ERROR.values().length);

        assertEquals(ERROR.GEN_ERR.getCode(), ERROR.valueOf("GEN_ERR").getCode());
        assertEquals(ERROR.GEN_ERR.getMessage(), ERROR.valueOf("GEN_ERR").getMessage());
        assertEquals(ERROR.GEN_ERR.getStatus(), ERROR.valueOf("GEN_ERR").getStatus());
    }

}