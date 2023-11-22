package com.aiforpet.core.error;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Map;

public record ErrorResponse(

        @Schema(description = """
                상세한 에러 설명
                발생한 에러에 대한 자세한 설명을 기재합니다.
                """,
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        String description,

        @Schema(description = """
                에러 코드
                발생한 에러에 대한 고유한 코드를 기재합니다.
                """,
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        ErrorCode errorCode,

        @Schema(description = """
                메세지
                오류 상황을 간략하게 설명합니다.
                """,
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        String message,

        @Schema(description = """
                Http Method
                해당 요청에 사용된 HTTP 메소드를 기재합니다.
                """,
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        String method,

        @Schema(description = """
                경로
                해당 요청이 발생한 경로를 기재합니다.
                """,
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
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
