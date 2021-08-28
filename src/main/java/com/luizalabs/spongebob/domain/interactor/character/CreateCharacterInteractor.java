package com.luizalabs.spongebob.domain.interactor.character;

import com.luizalabs.spongebob.domain.entity.Character;
import com.luizalabs.spongebob.domain.exception.ConflictException;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;

public interface CreateCharacterInteractor {
    Character execute(Character request) throws ConflictException, InternalServerErrorException;
}
