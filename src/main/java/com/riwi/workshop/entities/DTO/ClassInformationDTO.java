package com.riwi.workshop.entities.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@Schema(description = "DTO que representa la información de una clase")
public class ClassInformationDTO {

    @Schema(description = "Identificador único de la clase", example = "1")
    Long id;

    @Schema(description = "Nombre de la clase", example = "Matemáticas")
    String name;

    @Schema(description = "Descripción de la clase", example = "Clase de matemáticas avanzadas")
    String description;
}
