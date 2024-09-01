package com.riwi.workshop.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Entidad que representa una clase")
public class Class{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único de la clase", example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Nombre de la clase", example = "Matemáticas")
    private String name;

    @Column(nullable = false)
    @Schema(description = "Descripción de la clase", example = "Clase de matemáticas avanzadas")
    private String description;

    @Column(nullable = false)
    @Schema(description = "Estado activo de la clase", example = "true")
    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @Schema(description = "Estudiante asociado a la clase")
    private Student student;

}
