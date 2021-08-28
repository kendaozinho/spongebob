package com.luizalabs.spongebob.infraestructure.database.character.exception;

import com.luizalabs.spongebob.domain.exception.ConflictException;

public class CharacterNameAlreadyExistsException extends ConflictException {
    public CharacterNameAlreadyExistsException() {
        super("Character name already exists");
    }
}
