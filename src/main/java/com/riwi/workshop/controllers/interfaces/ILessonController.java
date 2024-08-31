package com.riwi.workshop.controllers.interfaces;

import com.riwi.workshop.controllers.generic.Create;
import com.riwi.workshop.controllers.generic.GetById;
import com.riwi.workshop.entities.Lesson;
import org.springframework.http.ResponseEntity;

public interface ILessonController extends
        Create<Lesson>,
        GetById<Lesson,Long> {
    ResponseEntity<Lesson> disableLesosnById(Long id);
}
