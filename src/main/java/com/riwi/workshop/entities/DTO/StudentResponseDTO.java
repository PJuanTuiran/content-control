package com.riwi.workshop.entities.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@Schema(description = "DTO que representa la respuesta detallada de un estudiante")
public class StudentResponseDTO {
    @Schema(description = "ID del estudiante", example = "1")
    private Long id;

    @Schema(description = "Nombre del estudiante", example = "Juan")
    private String name;

    @Schema(description = "Apellido del estudiante", example = "Pérez")
    private String lastName;

    @Schema(description = "Número de documento de identidad del estudiante", example = "12345678")
    private String dni;

    @Schema(description = "Correo electrónico del estudiante", example = "juan.perez@example.com")
    private String email;

    @Schema(description = "Estado activo del estudiante", example = "true")
    private Boolean active;

    @Schema(description = "Fecha de creación del registro del estudiante", example = "2024-08-31")
    private LocalDate createdAt;

    @Schema(description = "Conjunto de clases asociadas al estudiante")
    private Set<ClassInformationDTO> classes;
}