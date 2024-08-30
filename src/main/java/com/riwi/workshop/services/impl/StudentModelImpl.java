package com.riwi.workshop.services.impl;

import com.riwi.workshop.entities.DTO.ClassInformationDTO;
import com.riwi.workshop.entities.DTO.StudentOnlyClassInformationDTO;
import com.riwi.workshop.entities.Student;
import com.riwi.workshop.repositories.StudentRepository;
import com.riwi.workshop.services.Imodel.IStudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentModelImpl implements IStudentModel {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Page<StudentOnlyClassInformationDTO> getActiveStudents(int page, int size, String name) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Student> studentPage;

        if(name != null && !name.isEmpty()){
            studentPage = studentRepository.findByActiveTrueAndName(name, pageable);
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
}
