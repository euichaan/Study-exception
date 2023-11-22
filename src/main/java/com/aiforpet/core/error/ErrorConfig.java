package com.aiforpet.core.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorConfig {

    @Bean
    public ErrorProperties errorProperties() {
        ErrorProperties errorProperties = new ErrorProperties();
        errorProperties.setIncludeException(true);
        errorProperties.setIncludeMessage(ErrorProperties.IncludeAttribute.ALWAYS);
        errorProperties.setIncludeStacktrace(ErrorProperties.IncludeAttribute.ALWAYS);

        return errorProperties;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);
        return objectMapper;
    }
}
