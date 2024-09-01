package com.riwi.workshop.controllers.impl;

import com.riwi.workshop.controllers.interfaces.IStudentController;
import com.riwi.workshop.entities.DTO.StudentCreateDTO;
import com.riwi.workshop.entities.DTO.StudentOnlyClassInformationDTO;
import com.riwi.workshop.entities.DTO.StudentResponseDTO;
import com.riwi.workshop.entities.DTO.StudentUpdateDTO;
import com.riwi.workshop.entities.Student;
import com.riwi.workshop.services.impl.StudentModelImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@Validated
public class StudentController implements IStudentController {

    @Autowired
    StudentModelImpl studentModel;

    @Override
    @GetMapping("students")
    public ResponseEntity<Page<StudentOnlyClassInformationDTO>> getActiveStudents(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "name", required = false) String name
    ) {
        try {
            Page<StudentOnlyClassInformationDTO> studentsPage = studentModel.getActiveStudents(page, size, name);
            return new ResponseEntity<>(studentsPage, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception details if needed
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("students/{id}")
    public ResponseEntity<Student> getById(
            @PathVariable Long id
    ) {
        try {
            Optional<Student> optionalStudent = studentModel.getById(id);
            return optionalStudent.map(student -> new ResponseEntity<>(student, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("students")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentCreateDTO studentCreateDTO) {
        try {
            Student student = studentModel.create(studentCreateDTO);
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("students/{id}/disable")
    public ResponseEntity<StudentResponseDTO> disableStudent(@PathVariable Long id) {
        Optional<StudentResponseDTO> studentOptional = studentModel.disableStudent(id);
        return studentOptional.map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("students")
    @Override
    public ResponseEntity<StudentResponseDTO> updateStudent(
            @RequestParam(value = "id") Long id,
            @Valid @RequestBody StudentUpdateDTO studentUpdateDTO) {
        try {
            Optional<StudentResponseDTO> updatedStudent = studentModel.updateStudent(id, studentUpdateDTO);
            return updatedStudent.map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
