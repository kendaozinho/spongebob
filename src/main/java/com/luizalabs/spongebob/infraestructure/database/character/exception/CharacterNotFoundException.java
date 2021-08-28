package com.luizalabs.spongebob.infraestructure.database.character.exception;

import com.luizalabs.spongebob.domain.exception.NotFoundException;

public class CharacterNotFoundException extends NotFoundException {
    public CharacterNotFoundException() {
        super("Character(s) not found");
    }
}
