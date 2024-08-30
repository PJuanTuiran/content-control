package com.riwi.workshop.services.crud;

import java.util.Optional;

public interface GetByIdModel <Entity, ID>{
    Optional<Entity> getById(ID id);
}
