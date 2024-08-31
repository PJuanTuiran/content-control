package com.riwi.workshop.controllers;

import com.riwi.workshop.entities.Class;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface IClassController  {
     ResponseEntity<Page<Class>> getPaginatedClasses(String name, String description, int page, int size);
     public ResponseEntity<Class> getClassById( Long id);
     public ResponseEntity<Class> createClass( Class newClass);
}
