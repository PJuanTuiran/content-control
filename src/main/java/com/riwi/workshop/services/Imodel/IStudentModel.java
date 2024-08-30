package com.riwi.workshop.services.Imodel;

import com.riwi.workshop.entities.DTO.StudentOnlyClassInformationDTO;
import com.riwi.workshop.entities.Student;
import com.riwi.workshop.services.crud.GetByIdModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStudentModel extends GetByIdModel<Student, Long> {
    Page<StudentOnlyClassInformationDTO> getActiveStudents(int page, int size, String name);
}
