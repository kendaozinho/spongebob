package com.luizalabs.spongebob.domain.gateway.character;

import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.UUID;

public interface DeleteCharacterByIdGateway {
    void deleteOneById(UUID id) throws NotFoundException, InternalServerErrorException;
}
