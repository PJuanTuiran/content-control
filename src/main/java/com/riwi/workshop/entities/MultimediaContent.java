package com.riwi.workshop.entities;

import com.riwi.workshop.utils.ContentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString
@Entity
public class MultimediaContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ContentType contentType;
    private String url;
    @ManyToOne
    @JoinColumn(name = "idLesson")
    private Lesson idLesson;

}
