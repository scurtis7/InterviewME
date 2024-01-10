package com.scurtis.ime.exception;

import com.scurtis.ime.exception.model.ErrorResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(SpringExtension.class)
class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    void beforeEach() {
        globalExceptionHandler = spy(new GlobalExceptionHandler());
    }

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(globalExceptionHandler);
    }

    @Test
    void testHandleImeServerExceptionSuccess() {
        ImeServerException exception = new ImeServerException(HttpStatus.BAD_REQUEST, "message", "original");

        ResponseEntity<ErrorResponse> result = globalExceptionHandler.handleImeServerException(exception);

        ErrorResponse body = result.getBody();
        assertNotNull(body);
        assertEquals("message", body.message());
        assertEquals("original", body.exception());
        assertEquals("BAD_REQUEST", body.status());
        assertEquals(400, body.code());

        verify(globalExceptionHandler).handleImeServerException(exception);
    }

    @Test
    void testHandleExceptionInternal() {
        ImeServerException exception = new ImeServerException(HttpStatus.BAD_REQUEST, "message", "original");
        HttpHeaders headers = new HttpHeaders();

        ResponseEntity<Object> result = globalExceptionHandler.handleExceptionInternal(exception, "", headers, HttpStatus.BAD_REQUEST, null);

        ErrorResponse body = (ErrorResponse) result.getBody();
        assertNotNull(body);
        assertEquals("message", body.message());
        assertEquals("com.scurtis.ime.exception.ImeServerException", body.exception());
        assertEquals("BAD_REQUEST", body.status());
        assertEquals(400, body.code());

        verify(globalExceptionHandler).handleExceptionInternal(exception, "", headers, HttpStatus.BAD_REQUEST, null);
    }

}
