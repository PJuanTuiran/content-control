package com.riwi.workshop.controllers.impl;

import com.riwi.workshop.controllers.interfaces.IStudentController;
import com.riwi.workshop.entities.DTO.StudentCreateDTO;
import com.riwi.workshop.entities.DTO.StudentOnlyClassInformationDTO;
import com.riwi.workshop.entities.DTO.StudentResponseDTO;
import com.riwi.workshop.entities.DTO.StudentUpdateDTO;
import com.riwi.workshop.entities.Student;
import com.riwi.workshop.exception.EntityNotFoundException;
import com.riwi.workshop.services.impl.StudentModelImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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

    @Operation(summary = "Obtiene una lista de estudiantes activos",
            description = "Devuelve una lista de estudiantes activos con opciones de paginación y filtrado por nombre",
            responses = {
                    @ApiResponse(description = "Lista de estudiantes", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentOnlyClassInformationDTO.class))),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
            })
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

    @Operation(summary = "Obtiene un estudiante por ID",
            description = "Devuelve un estudiante específico según el ID proporcionado",
            responses = {
                    @ApiResponse(description = "Estudiante encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))),
                    @ApiResponse(responseCode = "404", description = "Estudiante no encontrado"),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
            })
    @GetMapping("students/{id}")
    public ResponseEntity<Student> getById(
            @PathVariable Long id
    ) {
        try {
            Student student = studentModel.getById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @Operation(summary = "Crea un nuevo estudiante",
            description = "Crea un nuevo estudiante con la información proporcionada",
            requestBody = @RequestBody(description = "Información del estudiante a crear", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentCreateDTO.class))),
            responses = {
                    @ApiResponse(description = "Estudiante creado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
            })
    @PostMapping("students")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentCreateDTO studentCreateDTO) {
        try {
            Student student = studentModel.create(studentCreateDTO);
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Desactiva un estudiante por ID",
            description = "Desactiva un estudiante específico según el ID proporcionado",
            responses = {
                    @ApiResponse(description = "Estudiante desactivado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentResponseDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Estudiante no encontrado"),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
            })
    @PatchMapping("students/{id}/disable")
    public ResponseEntity<StudentResponseDTO> disableStudent(@PathVariable Long id) {
        Optional<StudentResponseDTO> studentOptional = studentModel.disableStudent(id);
        return studentOptional.map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Actualiza la información de un estudiante",
            description = "Actualiza un estudiante existente con la información proporcionada",
            requestBody = @RequestBody(description = "Información del estudiante a actualizar", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentUpdateDTO.class))),
            responses = {
                    @ApiResponse(description = "Estudiante actualizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentResponseDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
                    @ApiResponse(responseCode = "404", description = "Estudiante no encontrado"),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
            })
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
