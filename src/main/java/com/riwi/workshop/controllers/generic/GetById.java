package com.riwi.workshop.controllers.generic;

import javax.swing.text.html.parser.Entity;

public interface GetById <Entity,ID> {
    public Entity getById(ID id);
}
