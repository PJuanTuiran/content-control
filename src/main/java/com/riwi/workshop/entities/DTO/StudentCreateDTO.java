package com.riwi.workshop.entities.DTO;

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
public class StudentCreateDTO {

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String name;

    @NotEmpty(message = "El apellido no puede estar vacío")
    private String lastName;

    @NotEmpty(message = "El DNI no puede estar vacío")
    private String dni;

    @Email(message = "El correo electrónico debe ser válido")
    @NotEmpty(message = "El correo electrónico no puede estar vacío")
    private String email;

    @NotNull(message = "El estado activo no puede ser nulo")
    private Boolean active;

    @NotNull(message = "Debe proporcionar al menos una clase")
    private Set<Long> classIds;
}