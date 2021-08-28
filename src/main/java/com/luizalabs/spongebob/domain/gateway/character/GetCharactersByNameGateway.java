package com.luizalabs.spongebob.domain.gateway.character;

import com.luizalabs.spongebob.domain.entity.Character;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.ArrayList;

public interface GetCharactersByNameGateway {
    ArrayList<Character> getAllByName(String name, Integer pageNumber, Integer pageSize) throws NotFoundException, InternalServerErrorException;
}
