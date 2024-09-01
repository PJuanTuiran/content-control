package com.riwi.workshop.entities.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "DTO para actualizar la información de un estudiante")
public class StudentUpdateDTO {

    @Schema(description = "Nombre del estudiante", example = "Juan")
    @NotEmpty(message = "The name can't be empty")
    private String name;

    @Schema(description = "Apellido del estudiante", example = "Pérez")
    @NotEmpty(message = "The lastName can't be empty")
    private String lastName;

    @Schema(description = "Número de documento de identidad del estudiante", example = "12345678")
    @NotEmpty(message = "The dni can't be empty")
    private String dni;

    @Schema(description = "Correo electrónico del estudiante", example = "juan.perez@example.com")
    @Email(message = "The email must be valid")
    @NotEmpty(message = "The email can't be empty")
    private String email;

    @Schema(description = "Estado activo del estudiante", example = "true")
    @NotNull(message = "The active status cannot be null")
    private Boolean active;
}
