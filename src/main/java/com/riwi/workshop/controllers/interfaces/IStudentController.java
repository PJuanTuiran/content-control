package com.riwi.workshop.controllers.interfaces;

import com.riwi.workshop.entities.DTO.StudentOnlyClassInformationDTO;
import com.riwi.workshop.entities.DTO.StudentResponseDTO;
import com.riwi.workshop.entities.DTO.StudentUpdateDTO;
import com.riwi.workshop.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IStudentController {
    ResponseEntity<Page<StudentOnlyClassInformationDTO>> getActiveStudents(int page, int size, String name);
    public ResponseEntity<Student> getById(Long id);
    ResponseEntity<StudentResponseDTO> disableStudent(Long id);
    ResponseEntity<StudentResponseDTO> updateStudent(Long id, StudentUpdateDTO studentUpdateDTO);
}
