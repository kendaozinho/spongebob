package com.luizalabs.spongebob.domain.gateway.character;

import com.luizalabs.spongebob.domain.entity.Character;
import com.luizalabs.spongebob.domain.exception.ConflictException;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.UUID;

public interface UpdateCharacterByIdGateway {
    Character update(UUID id, Character request) throws NotFoundException, ConflictException, InternalServerErrorException;
}
