package com.luizalabs.spongebob.gateway.character;

import com.luizalabs.spongebob.entity.Character;
import com.luizalabs.spongebob.exception.InternalServerErrorException;
import com.luizalabs.spongebob.exception.NotFoundException;

import java.util.UUID;

public interface GetCharacterByIdGateway {
    Character getOneById(UUID id) throws NotFoundException, InternalServerErrorException;
}
