package com.luizalabs.spongebob.domain.interactor.character;

import com.luizalabs.spongebob.domain.entity.Character;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.ArrayList;
import java.util.UUID;

public interface GetCharactersByFilterInteractor {
    ArrayList<Character> execute(UUID id, String name, Integer pageNumber, Integer pageSize)
            throws NotFoundException, InternalServerErrorException;
}
