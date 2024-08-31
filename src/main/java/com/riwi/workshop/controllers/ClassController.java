package com.riwi.workshop.controllers;

import com.riwi.workshop.entities.Class;
import com.riwi.workshop.services.Imodel.IClassModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}
