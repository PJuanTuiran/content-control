package com.riwi.workshop.controllers.impl;

import com.riwi.workshop.controllers.interfaces.IClassController;
import com.riwi.workshop.entities.Class;
import com.riwi.workshop.services.Imodel.IClassModel;
import com.riwi.workshop.services.impl.ClassModelImpl;
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
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/v1/class")
public class ClassController implements IClassController {

    @Autowired
    private ClassModelImpl iClassModel;

    @Operation(summary = "Obtiene una lista paginada de clases",
            description = "Devuelve una lista paginada de clases con opciones de filtrado por nombre y descripción",
            responses = {
                    @ApiResponse(description = "Lista de clases", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Class.class))),
                    @ApiResponse(responseCode = "204", description = "No se encontraron clases"),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
            })
    @Override
    @GetMapping
    public ResponseEntity<Page<Class>> getPaginatedClasses(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {


        Page<Class> paginatedClasses = iClassModel.getPaginatedClasses(name, description, page, size);


        if (paginatedClasses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(paginatedClasses);
    }

    @Operation(summary = "Obtiene una clase por ID",
            description = "Devuelve una clase específica según el ID proporcionado",
            responses = {
                    @ApiResponse(description = "Clase encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Class.class))),
                    @ApiResponse(responseCode = "404", description = "Clase no encontrada"),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
            })
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Class> getClassById(@PathVariable Long id) {
        Optional<Class> optionalClass = iClassModel.getClassById(id);

        if (optionalClass.isPresent()) {
            return ResponseEntity.ok(optionalClass.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Crea una nueva clase",
            description = "Crea una nueva clase con la información proporcionada",
            requestBody = @RequestBody(description = "Información de la clase a crear", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = Class.class))),
            responses = {
                    @ApiResponse(description = "Clase creada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Class.class))),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
            })
    @Override
    @PostMapping
    public ResponseEntity<Class> createClass(@Valid @RequestBody Class newClass) {

        Class savedClass = iClassModel.save(newClass);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedClass);
    }




}
