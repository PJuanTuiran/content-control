package com.riwi.workshop.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

    @Entity
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @SuperBuilder
    public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotEmpty
        @Column(length = 100, nullable = false)
        private String name;

        @NotEmpty
        @Column(length = 100, nullable = false)
        private String lastName;

        @NotEmpty
        @Column(length = 100, nullable = false)
        private String dni;

        @Email
        @NotEmpty
        @Column(length = 100, nullable = false)
        private String email;

        @Column(length = 255)
        @NotEmpty
        private String description;

        @Column(nullable = false, columnDefinition = "true")
        private Boolean active;

        @FutureOrPresent
        private LocalDate createdAt;
}
