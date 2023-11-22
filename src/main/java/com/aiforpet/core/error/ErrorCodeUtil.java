package com.aiforpet.core.error;

import jakarta.servlet.http.HttpServletRequest;

public class ErrorCodeUtil {

    public static ErrorResponse handle(HttpServletRequest request, ErrorCode errorCode, String errorMessage) {
        return new ErrorResponse(
                errorCode.getDescription(),
                errorCode,
                errorMessage,
                request.getMethod(),
                request.getRequestURI()
        );
    }
}
