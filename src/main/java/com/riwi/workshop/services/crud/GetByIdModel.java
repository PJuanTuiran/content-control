package com.riwi.workshop.services.crud;

import java.util.Optional;

public interface GetByIdModel <Entity, ID>{
    Entity getById(ID id);
}
