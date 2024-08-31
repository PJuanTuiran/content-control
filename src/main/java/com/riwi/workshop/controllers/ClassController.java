package com.riwi.workshop.controllers;

import com.riwi.workshop.entities.Class;
import com.riwi.workshop.services.Imodel.IClassModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class ClassController implements IClassController {

    @Autowired
    private IClassModel iClassModel;

    @Override
    @GetMapping("/class")
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
    @Override
    @GetMapping("/class")
    public ResponseEntity<Class> getClassById(@RequestParam Long id) {
        Optional<Class> optionalClass = iClassModel.getClassById(id);

        if (optionalClass.isPresent()) {
            return ResponseEntity.ok(optionalClass.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Override
    @PostMapping("/class")
    public ResponseEntity<Class> createClass(@Valid @RequestBody Class newClass) {

        Class savedClass = iClassModel.save(newClass);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedClass);
    }




}
