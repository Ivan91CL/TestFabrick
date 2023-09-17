package com.fabrick.testfabrick.logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.HandlerExecutionChain;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@SpringBootTest
public class LoggingInterceptorTest {

    @Autowired
    private LoggingInterceptor loggingInterceptor;

    @Test
    public void preHandle() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        HandlerExecutionChain executionChain = mock(HandlerExecutionChain.class);

        boolean result = loggingInterceptor.preHandle(request, response, executionChain);

        assertTrue(result);
    }

    @Test
    public void afterCompletion() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        Exception exception = new Exception("Test Exception");

        // Chiamata al metodo afterCompletion
        loggingInterceptor.afterCompletion(request, response, new Object(), exception);
    }
}