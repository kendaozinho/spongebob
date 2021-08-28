package com.luizalabs.spongebob.gateway.character;

import com.luizalabs.spongebob.entity.Character;
import com.luizalabs.spongebob.exception.ConflictException;
import com.luizalabs.spongebob.exception.InternalServerErrorException;
import com.luizalabs.spongebob.exception.NotFoundException;

import java.util.UUID;

public interface UpdateCharacterByIdGateway {
    Character update(UUID id, Character request) throws NotFoundException, ConflictException, InternalServerErrorException;
}
