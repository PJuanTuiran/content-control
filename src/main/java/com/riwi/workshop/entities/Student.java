package com.riwi.workshop.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Schema(description = "Entidad que representa un estudiante")
    public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único del estudiante", example = "1")
    private Long id;

    @NotEmpty(message = "the name can't be empty")
    @Column(length = 100, nullable = false)
    @Schema(description = "Nombre del estudiante", example = "Juan")
    private String name;

    @NotEmpty(message = "the lastName can't be empty")
    @Column(length = 100, nullable = false)
    @Schema(description = "Apellido del estudiante", example = "Pérez")
    private String lastName;

    @NotEmpty(message = "the dni can't be empty")
    @Column(length = 100, nullable = false)
    @Schema(description = "Número de documento de identidad del estudiante", example = "12345678")
    private String dni;

    @Email
    @NotEmpty(message = "the email can't be empty")
    @Column(length = 100, nullable = false)
    @Schema(description = "Correo electrónico del estudiante", example = "juan.perez@example.com")
    private String email;

    @NotNull(message = "The active status cannot be null")
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    @Schema(description = "Estado activo del estudiante", example = "true")
    private Boolean active;

    @PastOrPresent(message = "La fecha de creación debe ser en el pasado o presente")
    @Column(nullable = false)
    @Schema(description = "Fecha de creación del registro del estudiante", example = "2024-08-31")
    private LocalDate createdAt;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(description = "Lista de clases asociadas al estudiante")
    private List<Class> classes;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
    }
}
