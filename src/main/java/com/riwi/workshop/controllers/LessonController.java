package com.riwi.workshop.controllers;

import com.riwi.workshop.controllers.interfaces.ILessonController;
import com.riwi.workshop.entities.Lesson;
import com.riwi.workshop.services.Imodel.ILessonModel;
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
public class LessonController implements ILessonController {

    @Autowired
    ILessonModel lessonService;

//    @Override
//    @PostMapping
//    public ResponseEntity<Lesson> create(@RequestBody @Valid Lesson lesson) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(lessonService.create(lesson));
//    }

    public ResponseEntity<Lesson> create(@RequestBody @Valid Lesson lesson) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(lessonService.create(lesson));
        }catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
