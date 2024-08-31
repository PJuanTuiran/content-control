package com.riwi.workshop.services.Imodel;

import com.riwi.workshop.entities.Lesson;
import com.riwi.workshop.services.crud.CreateModel;

public interface ILessonModel extends
        CreateModel<Lesson>{
    void disableLessonById (int id);
}
