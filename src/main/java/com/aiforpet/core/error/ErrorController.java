package com.aiforpet.core.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class ErrorController extends BasicErrorController {

    public ErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
        super(errorAttributes, errorProperties);
    }

    @Override
    protected Map<String, Object> getErrorAttributes(HttpServletRequest request, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(request, options);
        ErrorCode errorCode = ErrorCode.UNDEFINED;

        Object error = errorAttributes.get("error");
        Object status = errorAttributes.get("status");
        if (validateNotFound(error, status)) {
            errorCode = ErrorCode.E005;
        }

        ErrorResponse errorResponse = createErrorResponse(request, errorCode, errorAttributes);
        return errorResponse.toMap();
    }

    private boolean validateNotFound(Object error, Object status) {
        return "Not Found".equals(error) && (Integer)status == 404;
    }

    private static ErrorResponse createErrorResponse(HttpServletRequest request, ErrorCode errorCode, Map<String, Object> errorAttributes) {
        return new ErrorResponse(
                errorCode.getDescription(),
                errorCode,
                (String) errorAttributes.getOrDefault("message", errorCode.getDescription()),
                request.getMethod(),
                (String) errorAttributes.get("path")
        );
    }
}
