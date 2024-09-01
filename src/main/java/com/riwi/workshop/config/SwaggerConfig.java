package com.riwi.workshop.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Student, Lesson, and Class API",
        version = "1.0",
        description = "API documentation for managing students, lessons, and classes.",
        contact = @Contact(name = "cualquier cosa", email = "diegomejiasobsu@gmail.com")
))
public class SwaggerConfig {
}
