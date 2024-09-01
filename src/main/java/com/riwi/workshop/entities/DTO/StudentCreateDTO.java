package com.riwi.workshop.entities.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO para crear un estudiante")
public class StudentCreateDTO {

    @Schema(description = "Nombre del estudiante", example = "Juan")
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String name;

    @Schema(description = "Apellido del estudiante", example = "Pérez")
    @NotEmpty(message = "El apellido no puede estar vacío")
    private String lastName;

    @Schema(description = "Número de documento de identidad del estudiante", example = "12345678")
    @NotEmpty(message = "El DNI no puede estar vacío")
    private String dni;

    @Schema(description = "Correo electrónico del estudiante", example = "juan.perez@example.com")
    @Email(message = "El correo electrónico debe ser válido")
    @NotEmpty(message = "El correo electrónico no puede estar vacío")
    private String email;

    @Schema(description = "Estado activo del estudiante", example = "true")
    @NotNull(message = "El estado activo no puede ser nulo")
    private Boolean active;

    @Schema(description = "IDs de las clases a las que el estudiante está asociado", example = "[1, 2, 3]")
    @NotNull(message = "Debe proporcionar al menos una clase")
    private Set<Long> classIds;
}