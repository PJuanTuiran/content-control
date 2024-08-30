package com.riwi.workshop.services.impl;

import com.riwi.workshop.entities.Lesson;
import com.riwi.workshop.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LessonModelImpl {

    @Autowired
    LessonRepository lessonRepository;

    public Lesson saveLesson(Lesson lesson){
        return lessonRepository.save(lesson);
    }
}
