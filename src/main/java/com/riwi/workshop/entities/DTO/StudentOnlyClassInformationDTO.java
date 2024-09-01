package com.riwi.workshop.entities.DTO;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class StudentOnlyClassInformationDTO {
    Long studentId;
    List<ClassInformationDTO> classes;
}
