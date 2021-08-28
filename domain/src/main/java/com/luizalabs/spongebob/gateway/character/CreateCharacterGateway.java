package com.luizalabs.spongebob.domain.gateway.character;

import com.luizalabs.spongebob.domain.entity.Character;
import com.luizalabs.spongebob.domain.exception.ConflictException;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;

public interface CreateCharacterGateway {
    Character create(Character request) throws ConflictException, InternalServerErrorException;
}
