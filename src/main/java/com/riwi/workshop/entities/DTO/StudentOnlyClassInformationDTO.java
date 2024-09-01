package com.riwi.workshop.entities.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@Schema(description = "DTO que representa la información de un estudiante y sus clases")
public class StudentOnlyClassInformationDTO {
    @Schema(description = "ID del estudiante", example = "1")
    Long studentId;

    @Schema(description = "Lista de clases asociadas al estudiante")
    List<ClassInformationDTO> classes;
}
