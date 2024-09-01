package com.riwi.workshop.entities.DTO;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ClassInformationDTO {
    Long id;
    String name;
    String description;
}
