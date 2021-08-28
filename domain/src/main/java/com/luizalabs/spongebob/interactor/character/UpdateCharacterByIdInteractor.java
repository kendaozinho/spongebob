package com.luizalabs.spongebob.domain.interactor.character;

import com.luizalabs.spongebob.domain.entity.Character;
import com.luizalabs.spongebob.domain.exception.ConflictException;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.UUID;

public interface UpdateCharacterByIdInteractor {
    Character execute(UUID id, Character request) throws NotFoundException, ConflictException, InternalServerErrorException;
}
