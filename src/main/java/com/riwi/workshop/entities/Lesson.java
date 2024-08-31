package com.riwi.workshop.entities;

import com.riwi.workshop.utils.ContentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Requiered title")
    @Column(nullable = false)
    private String title;
    @NotNull(message = "Requiered description")
    @Column(nullable = false)
    private String description;
    private List<ContentType> multimediaContent;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Requiered type Content")
    private ContentType type;
    @NotNull(message = "Requiered url")
    @Size(max = 255,message = "Requiered url")
    private String url;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private Boolean status;

}
