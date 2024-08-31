package com.riwi.workshop.services.Imodel;

import com.riwi.workshop.entities.Lesson;
import com.riwi.workshop.services.crud.CreateModel;
import com.riwi.workshop.services.crud.GetByIdModel;

public interface ILessonModel extends
        CreateModel<Lesson>,
        GetByIdModel<Lesson,Long> {
    Lesson disableLessonById (Long id);
}
