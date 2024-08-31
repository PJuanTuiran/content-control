package com.riwi.workshop.services.crud;

public interface GetByIdModel <Entity,ID> {
    public Entity getByIdModel(ID id);
}
