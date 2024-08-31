package com.riwi.workshop.services.crud;

import jakarta.persistence.Entity;

public interface CreateModel <Entity> {
    public Entity create (Entity entity);
}
