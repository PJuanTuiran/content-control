package com.riwi.workshop.services.Imodel;

import com.riwi.workshop.entities.Class;
import com.riwi.workshop.services.crud.CreateModel;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IClassModel extends CreateModel<Class> {
    public Page<Class> getPaginatedClasses(String name, String description, int page, int size);
    public Optional<Class>  getClassById(Long id);
}
