package com.luizalabs.spongebob.gateway.character;

import com.luizalabs.spongebob.exception.InternalServerErrorException;
import com.luizalabs.spongebob.exception.NotFoundException;

import java.util.UUID;

public interface DeleteCharacterByIdGateway {
    void deleteOneById(UUID id) throws NotFoundException, InternalServerErrorException;
}
