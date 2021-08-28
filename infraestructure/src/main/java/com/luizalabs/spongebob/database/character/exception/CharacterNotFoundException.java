package com.luizalabs.spongebob.database.character.exception;

import com.luizalabs.spongebob.exception.NotFoundException;

public class CharacterNotFoundException extends NotFoundException {
    public CharacterNotFoundException() {
        super("Character(s) not found");
    }
}
