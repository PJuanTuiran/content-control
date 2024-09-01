package com.riwi.workshop.entities;

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
    public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotEmpty(message = "the name can't be empty")
        @Column(length = 100, nullable = false)
        private String name;

        @NotEmpty(message = "the lastName can't be empty")
        @Column(length = 100, nullable = false)
        private String lastName;

        @NotEmpty(message = "the dni can't be empty")
        @Column(length = 100, nullable = false)
        private String dni;

        @Email
        @NotEmpty(message = "the email can't be empty")
        @Column(length = 100, nullable = false)
        private String email;

        @NotNull(message = "The active status cannot be null")
        @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
        private Boolean active;

        @PastOrPresent(message = "La fecha de creación debe ser en el pasado o presente")
        @Column(nullable = false)
        private LocalDate createdAt;

        @ManyToMany
        @JoinTable(name = "student_class", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "class_id")
        )
        private List<Class> classes;

        @PrePersist
        protected void onCreate() {
          this.createdAt = LocalDate.now();
        }
}
