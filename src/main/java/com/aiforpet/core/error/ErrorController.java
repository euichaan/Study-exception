package com.aiforpet.core.error;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Slf4j
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class ErrorController extends BasicErrorController {

    public ErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
        super(errorAttributes, errorProperties);
    }

    @Override
    protected Map<String, Object> getErrorAttributes(HttpServletRequest request, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(request, options);
        errorAttributes.forEach((key, value) -> System.out.println(key + " " + value));

        log.error("trace = {}", errorAttributes.get("trace"));
        ErrorCode errorCode = ErrorCode.UNDEFINED;

        ErrorResponse errorResponse = new ErrorResponse(
                errorCode.getDescription(),
                errorCode,
                (String) errorAttributes.getOrDefault("message", errorCode.getDescription()),
                request.getMethod(),
                (String) errorAttributes.get("path")
        );
        return errorResponse.toMap();
    }
}
