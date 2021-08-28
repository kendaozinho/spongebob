package com.luizalabs.spongebob.gateway.character;

import com.luizalabs.spongebob.entity.Character;
import com.luizalabs.spongebob.exception.ConflictException;
import com.luizalabs.spongebob.exception.InternalServerErrorException;

public interface CreateCharacterGateway {
    Character create(Character request) throws ConflictException, InternalServerErrorException;
}
