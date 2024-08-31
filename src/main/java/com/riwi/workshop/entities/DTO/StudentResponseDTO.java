package com.riwi.workshop.entities.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class StudentResponseDTO {
    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private String email;
    private Boolean active;
    private LocalDate createdAt;
    private Set<ClassInformationDTO> classes;
}