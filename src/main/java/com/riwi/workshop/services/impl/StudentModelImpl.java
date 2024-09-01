package com.riwi.workshop.services.impl;

import com.riwi.workshop.entities.Class;
import com.riwi.workshop.entities.DTO.*;
import com.riwi.workshop.entities.Student;
import com.riwi.workshop.exception.EntityNotFoundException;
import com.riwi.workshop.repositories.ClassRepository;
import com.riwi.workshop.repositories.StudentRepository;
import com.riwi.workshop.services.Imodel.IStudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentModelImpl implements IStudentModel {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClassRepository classRepository;

    @Override
    public Page<StudentOnlyClassInformationDTO> getActiveStudents(int page, int size, String name) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Student> studentPage;

        if(name != null && !name.isEmpty()){
            studentPage = studentRepository.findByActiveTrueAndNameContainingIgnoreCase(name, pageable);
        }else{
            studentPage = studentRepository.findByActiveTrue(pageable);
        }

        return studentPage.map(student -> {
            List<ClassInformationDTO> classDTOs = student.getClasses().stream()
                    .map(cls -> ClassInformationDTO.builder()
                            .id(cls.getId())
                            .name(cls.getName())
                            .description(cls.getDescription())
                            .build())
                    .collect(Collectors.toList());

            return StudentOnlyClassInformationDTO.builder()
                    .studentId(student.getId())
                    .classes(classDTOs)
                    .build();
        });
    }

    @Override
    public Optional<StudentResponseDTO> disableStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setActive(false);
            student = studentRepository.save(student);
            StudentResponseDTO responseDTO = StudentResponseDTO.builder()
                    .id(student.getId())
                    .name(student.getName())
                    .lastName(student.getLastName())
                    .dni(student.getDni())
                    .email(student.getEmail())
                    .active(student.getActive())
                    .createdAt(student.getCreatedAt())
                    .classes(student.getClasses().stream()
                            .map(cls -> ClassInformationDTO.builder()
                                    .id(cls.getId())
                                    .name(cls.getName())
                                    .description(cls.getDescription())
                                    .build())
                            .collect(Collectors.toSet()))
                    .build();

            return Optional.of(responseDTO);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<StudentResponseDTO> updateStudent(Long id, StudentUpdateDTO studentUpdateDTO) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (!optionalStudent.isPresent()) {
            return Optional.empty();
        }

        Student student = optionalStudent.get();
        student.setName(studentUpdateDTO.getName());
        student.setLastName(studentUpdateDTO.getLastName());
        student.setDni(studentUpdateDTO.getDni());
        student.setEmail(studentUpdateDTO.getEmail());
        student.setActive(studentUpdateDTO.getActive());

        try {
            student = studentRepository.save(student);
        } catch (Exception e) {
            throw new RuntimeException("Error updating student", e);
        }

        StudentResponseDTO responseDTO = StudentResponseDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .lastName(student.getLastName())
                .dni(student.getDni())
                .email(student.getEmail())
                .active(student.getActive())
                .createdAt(student.getCreatedAt())
                .classes(student.getClasses().stream()
                        .map(cls -> ClassInformationDTO.builder()
                                .id(cls.getId())
                                .name(cls.getName())
                                .description(cls.getDescription())
                                .build())
                        .collect(Collectors.toSet()))
                .build();
        return Optional.of(responseDTO);
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Student with ID " + id + " not found"));
    }

    @Override
    public Student create(StudentCreateDTO studentCreateDTO) {

        List<Class> classes = classRepository.findAllById(studentCreateDTO.getClassIds());
        if (classes.size() != studentCreateDTO.getClassIds().size()) {
            throw new IllegalArgumentException("Algunas de las clases especificadas no existen");
        }

        Student student = Student.builder()
                .name(studentCreateDTO.getName())
                .lastName(studentCreateDTO.getLastName())
                .dni(studentCreateDTO.getDni())
                .email(studentCreateDTO.getEmail())
                .active(studentCreateDTO.getActive())
                .classes(classes)
                .build();

        return studentRepository.save(student);

    }
}
