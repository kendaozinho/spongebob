package com.luizalabs.spongebob.domain.gateway.character;

import com.luizalabs.spongebob.domain.entity.Character;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.ArrayList;

public interface GetAllCharactersGateway {
    ArrayList<Character> getAll(Integer pageNumber, Integer pageSize) throws NotFoundException, InternalServerErrorException;
}
