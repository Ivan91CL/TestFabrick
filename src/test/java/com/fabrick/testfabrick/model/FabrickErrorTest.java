package com.fabrick.testfabrick.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FabrickErrorTest {

    @Test
    public void test(){
        FabrickError model1 = new FabrickError();
        model1.setCode("");
        model1.setParams("");
        model1.setDescription("");

        FabrickError model2 = new FabrickError();
        model2.setCode("");
        model2.setParams("");
        model2.setDescription("");

        assertEquals(model1, model2);
        assertEquals(model1.hashCode(), model2.hashCode());
    }

}