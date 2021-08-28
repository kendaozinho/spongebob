package com.luizalabs.spongebob.database.character.exception;

import com.luizalabs.spongebob.exception.ConflictException;

public class CharacterNameAlreadyExistsException extends ConflictException {
    public CharacterNameAlreadyExistsException() {
        super("Character name already exists");
    }
}
