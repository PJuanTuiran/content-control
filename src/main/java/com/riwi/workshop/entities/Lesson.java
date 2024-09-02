package com.riwi.workshop.entities;

import com.riwi.workshop.utils.ContentType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Schema(description = "Entidad que representa una lección")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único de la lección", example = "1")
    private Long id;

    @NotNull(message = "Requiered title")
    @Column(nullable = false)
    @Schema(description = "Título de la lección", example = "Introducción a la Física")
    private String title;

    @NotNull(message = "Requiered description")
    @Column(nullable = false)
    @Schema(description = "Descripción de la lección", example = "Lección introductoria sobre conceptos básicos de física")
    private String description;

    @Schema(description = "Contenido multimedia asociado a la lección", example = "[\"VIDEO\", \"PDF\"]")
    @OneToMany(mappedBy = "idLesson")
    private Set<MultimediaContent> multimediaContent;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Requiered type Content")
    @Schema(description = "Tipo de contenido de la lección", example = "VIDEO")
    private ContentType type;

    @NotNull(message = "Requiered url")
    @Size(max = 255, message = "Requiered url")
    @Schema(description = "URL de la lección", example = "http://example.com/lesson")
    private String url;

    @Column(nullable = false, columnDefinition = "boolean default true")
    @Schema(description = "Estado de la lección", example = "true")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "idClass")
    private Class idClass;


}
