package com.YanVkhv.infrastructure.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String additionalContext, Class classOfEntity, Long id) {
        super("During " + additionalContext + ", the following entity was not found: "
                + classOfEntity.getSimpleName() + " with id = " + id);
    }
}
