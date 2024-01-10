package com.scurtis.ime.exception;

import com.scurtis.ime.exception.model.ErrorResponse;
import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ImeServerException.class)
    protected ResponseEntity<ErrorResponse> handleImeServerException(ImeServerException exception) {
        log.error("ImeServerException", exception);
        return ResponseEntity.status(exception.getStatus())
            .contentType(MediaType.APPLICATION_JSON)
            .body(buildErrorMessage(exception));
    }

    protected ResponseEntity<Object> handleExceptionInternal(Exception exception, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = buildErrorMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), exception.getClass().getName(), exception.getMessage());
        return ResponseEntity.status(status).body(response);
    }

    private ErrorResponse buildErrorMessage(ImeServerException exception) {
        return new ErrorResponse(exception.getStatus().value(), exception.getStatus().name(), exception.getOriginal(), exception.getMessage(), LocalDate.now());
    }

    private ErrorResponse buildErrorMessage(int code, String status, String exception, String message) {
        return new ErrorResponse(code, status, exception, message, LocalDate.now());
    }

}
