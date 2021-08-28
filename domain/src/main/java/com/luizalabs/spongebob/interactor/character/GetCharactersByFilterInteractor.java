package com.luizalabs.spongebob.interactor.character;

import com.luizalabs.spongebob.entity.Character;
import com.luizalabs.spongebob.exception.InternalServerErrorException;
import com.luizalabs.spongebob.exception.NotFoundException;

import java.util.ArrayList;
import java.util.UUID;

public interface GetCharactersByFilterInteractor {
    ArrayList<Character> execute(UUID id, String name, Integer pageNumber, Integer pageSize)
            throws NotFoundException, InternalServerErrorException;
}
