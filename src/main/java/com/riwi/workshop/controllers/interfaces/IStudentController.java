package com.riwi.workshop.controllers.interfaces;

import com.riwi.workshop.entities.DTO.StudentOnlyClassInformationDTO;
import com.riwi.workshop.entities.Student;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IStudentController {
    Page<StudentOnlyClassInformationDTO> getActiveStudents(int page, int size, String name);
    public Optional<Student> getById(Long id);
}
