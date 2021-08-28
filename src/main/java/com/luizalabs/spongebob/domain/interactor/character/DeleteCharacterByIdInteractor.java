package com.luizalabs.spongebob.domain.interactor.character;

import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.UUID;

public interface DeleteCharacterByIdInteractor {
    void execute(UUID id) throws NotFoundException, InternalServerErrorException;
}
