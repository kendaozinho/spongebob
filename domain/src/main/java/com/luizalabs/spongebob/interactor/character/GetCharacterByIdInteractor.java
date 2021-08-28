package com.luizalabs.spongebob.interactor.character;

import com.luizalabs.spongebob.entity.Character;
import com.luizalabs.spongebob.exception.InternalServerErrorException;
import com.luizalabs.spongebob.exception.NotFoundException;

import java.util.UUID;

public interface GetCharacterByIdInteractor {
    Character execute(UUID id) throws NotFoundException, InternalServerErrorException;
}
