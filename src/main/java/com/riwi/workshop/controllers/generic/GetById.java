package com.riwi.workshop.controllers.generic;

import org.springframework.http.ResponseEntity;

import javax.swing.text.html.parser.Entity;

public interface GetById <Entity,ID> {
    public ResponseEntity<Entity> getById(ID id);
}
