package com.aiforpet.core.error;

import java.util.Map;

public record ErrorResponse(

        String description,
        ErrorCode errorCode,
        String message,
        String method,
        String path
) {

        public Map<String, Object> toMap() {
            return Map.of(
                    "description", errorCode.getDescription(),
                    "errorCode", errorCode,
                    "message", message,
                    "method", method,
                    "path", path
            );
        }
}
