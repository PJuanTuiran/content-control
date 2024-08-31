package com.riwi.workshop.services.impl;

import com.riwi.workshop.entities.Class;
import com.riwi.workshop.repositories.ClassRepository;
import com.riwi.workshop.services.Imodel.IClassModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class ClassModelImpl implements IClassModel {
    @Autowired
    ClassRepository classRepository;
    @Override
    public Page<Class> getPaginatedClasses(String name, String description, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return classRepository.findByActiveTrueAndNameContainingAndDescriptionContaining(name, description, pageable);
    }
}
