package com.riwi.workshop.controllers;

import com.riwi.workshop.entities.DTO.StudentOnlyClassInformationDTO;
import com.riwi.workshop.entities.Student;
import com.riwi.workshop.services.impl.StudentModelImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {

    @Autowired
    StudentModelImpl studentModel;

    @GetMapping("students")
    public Page<StudentOnlyClassInformationDTO> getActiveStudents(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "name", required = false) String name
    ){
        return studentModel.getActiveStudents(page, size, name);
    }

    @GetMapping("students/{id}")
    public Optional<Student> getById(
            @PathVariable Long id
    ){
        return studentModel.getById(id);
    }


}
