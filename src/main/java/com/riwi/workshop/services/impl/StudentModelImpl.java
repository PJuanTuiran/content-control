package com.riwi.workshop.services.impl;

import com.riwi.workshop.entities.Student;
import com.riwi.workshop.repositories.StudentRepository;
import com.riwi.workshop.services.Imodel.IStudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class StudentModelImpl implements IStudentModel {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Page<Student> getByName(String name, int page, int size) {
        return null;
    }
}
