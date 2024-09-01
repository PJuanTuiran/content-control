package com.riwi.workshop.entities.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentUpdateDTO {

    @NotEmpty(message = "The name can't be empty")
    private String name;

    @NotEmpty(message = "The lastName can't be empty")
    private String lastName;

    @NotEmpty(message = "The dni can't be empty")
    private String dni;

    @Email(message = "The email must be valid")
    @NotEmpty(message = "The email can't be empty")
    private String email;

    @NotNull(message = "The active status cannot be null")
    private Boolean active;
}
