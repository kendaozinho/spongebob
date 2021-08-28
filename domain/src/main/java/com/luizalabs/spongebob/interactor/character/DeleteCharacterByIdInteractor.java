package com.luizalabs.spongebob.interactor.character;

import com.luizalabs.spongebob.exception.InternalServerErrorException;
import com.luizalabs.spongebob.exception.NotFoundException;

import java.util.UUID;

public interface DeleteCharacterByIdInteractor {
    void execute(UUID id) throws NotFoundException, InternalServerErrorException;
}
