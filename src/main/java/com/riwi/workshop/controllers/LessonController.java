package com.riwi.workshop.controllers;

import com.riwi.workshop.entities.Lesson;
import com.riwi.workshop.services.impl.LessonModelImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/api/vi/lesson")
public class LessonController {

    @Autowired
    LessonModelImpl lessonModel;

    @PostMapping
    public ResponseEntity<Lesson> saveLesson(@RequestBody @Valid Lesson lesson){
        return ResponseEntity.status(HttpStatus.CREATED).body(lessonModel.saveLesson(lesson));
    }

}
