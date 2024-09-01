package com.riwi.workshop.controllers.impl;

import com.riwi.workshop.controllers.interfaces.ILessonController;
import com.riwi.workshop.entities.Lesson;
import com.riwi.workshop.services.Imodel.ILessonModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/vi/lesson")
public class LessonController implements ILessonController {

    @Autowired
    ILessonModel lessonService;

//    @Override
//    @PostMapping
//    public ResponseEntity<Lesson> create(@RequestBody @Valid Lesson lesson) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(lessonService.create(lesson));
//    }

    @Operation(summary = "Crea una nueva lección",
            description = "Crea una nueva lección con la información proporcionada",
            requestBody = @RequestBody(description = "Información de la lección a crear", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = Lesson.class))),
            responses = {
                    @ApiResponse(description = "Lección creada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Lesson.class))),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
            })
    @PostMapping
    public ResponseEntity<Lesson> create(@RequestBody @Valid Lesson lesson) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(lessonService.create(lesson));
        }catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Desactiva una lección por ID",
            description = "Desactiva una lección específica según el ID proporcionado",
            responses = {
                    @ApiResponse(description = "Lección desactivada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Lesson.class))),
                    @ApiResponse(responseCode = "404", description = "Lección no encontrada"),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
            })
    @Override
    @PatchMapping("/{id}/disable")
    public ResponseEntity<Lesson> disableLesosnById(@PathVariable @ Valid Long id) {
         return ResponseEntity.ok(lessonService.disableLessonById(id));
    }

    @Operation(summary = "Obtiene una lección por ID",
            description = "Devuelve una lección específica según el ID proporcionado",
            responses = {
                    @ApiResponse(description = "Lección encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Lesson.class))),
                    @ApiResponse(responseCode = "404", description = "Lección no encontrada"),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
            })
    @Override
    @GetMapping("/{id}/multimedia")
    public ResponseEntity<Lesson> getById(@PathVariable Long id) {
        return ResponseEntity.ok(lessonService.getById(id));
    }
}
