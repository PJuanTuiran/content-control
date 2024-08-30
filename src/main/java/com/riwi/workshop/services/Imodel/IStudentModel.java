package com.riwi.workshop.services.Imodel;

import com.riwi.workshop.entities.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStudentModel {
    Page<Student> getByName(String name, int page, int size);
}
