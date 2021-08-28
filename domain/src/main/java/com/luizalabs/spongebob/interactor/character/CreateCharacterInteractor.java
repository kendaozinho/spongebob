package com.luizalabs.spongebob.interactor.character;

import com.luizalabs.spongebob.entity.Character;
import com.luizalabs.spongebob.exception.ConflictException;
import com.luizalabs.spongebob.exception.InternalServerErrorException;

public interface CreateCharacterInteractor {
    Character execute(Character request) throws ConflictException, InternalServerErrorException;
}
