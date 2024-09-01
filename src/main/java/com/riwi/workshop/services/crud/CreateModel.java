package com.riwi.workshop.services.crud;

public interface CreateModel <E ,Entity> {
    public E create(Entity entity);
}
