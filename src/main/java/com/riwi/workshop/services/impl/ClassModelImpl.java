package com.riwi.workshop.services.impl;

import com.riwi.workshop.entities.Class;
import com.riwi.workshop.repositories.ClassRepository;
import com.riwi.workshop.services.Imodel.IClassModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClassModelImpl implements IClassModel {
    @Autowired
    ClassRepository classRepository;
    @Override
    public Page<Class> getPaginatedClasses(String name, String description, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return classRepository.findByActiveTrueAndNameContainingAndDescriptionContaining(name, description, pageable);
    }

    @Override
    public Optional<Class> getClassById(Long id) {
        return classRepository.findByIdAndActiveTrue(id);
    }

    @Override
    public Class save(Class aClass) {
        return classRepository.save(aClass);
    }
}