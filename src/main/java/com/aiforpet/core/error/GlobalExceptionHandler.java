package com.aiforpet.core.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleIllegalArgumentError(HttpServletRequest request, IllegalArgumentException e) {
        return ErrorCodeUtil.handle(request, ErrorCode.E004, e.getMessage());
    }

    @Override
    protected ResponseEntity<Object> createResponseEntity(Object body, HttpHeaders headers,
                                                          HttpStatusCode statusCode, WebRequest request) {
        Object servletWebRequest = ((ServletWebRequest) request).getNativeRequest();
        ErrorCode errorCode = ErrorCode.E001;
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorCodeUtil.handle((HttpServletRequest) servletWebRequest, errorCode, errorCode.getDescription()));
    }
}
