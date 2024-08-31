package com.riwi.workshop.services.crud;

import javax.swing.text.html.parser.Entity;

public interface CreateModel<Entity> {
    public Entity save(Entity entity);
}
