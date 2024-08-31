package com.riwi.workshop.services.impl;

import com.riwi.workshop.entities.Lesson;
import com.riwi.workshop.repositories.LessonRepository;
import com.riwi.workshop.services.Imodel.ILessonModel;
import org.springframework.beans.factory.annotation.Autowired;

public class LessonModelImpl implements ILessonModel {

    @Autowired
    LessonRepository lessonRepository;

    @Override
    public Lesson create(Lesson lesson) {
        return lessonRepository.save(lesson);
    }
}
