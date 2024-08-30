package com.riwi.workshop.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "I don't know what i can put it",
        version = "1.0",
        description = "This is a workshop :)"
))
public class SwaggerConfig {
}
