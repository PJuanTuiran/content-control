package com.riwi.workshop.services.impl;


import com.riwi.workshop.entities.Lesson;
import com.riwi.workshop.repositories.LessonRepository;
import com.riwi.workshop.services.Imodel.ILessonModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LessonModelImpl implements ILessonModel {

    @Autowired
    LessonRepository lessonRepository;

    @Override
    public Lesson create(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson disableLessonById(Long id) {
        Optional<Lesson> optionaLesson = lessonRepository.findById(id);
        if(optionaLesson.isPresent()){
            Lesson lesson = optionaLesson.get();
            lesson.setStatus(false);
            return lessonRepository.save(lesson);
        }else{
            throw new EntityNotFoundException("Id not found");
        }
    }

    @Override
    public Lesson getById(Long id) {
        return lessonRepository.findById(id).orElseThrow();
    }


}
