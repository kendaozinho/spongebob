package com.luizalabs.spongebob.gateway.character;

import com.luizalabs.spongebob.entity.Character;
import com.luizalabs.spongebob.exception.InternalServerErrorException;
import com.luizalabs.spongebob.exception.NotFoundException;

import java.util.ArrayList;

public interface GetAllCharactersGateway {
    ArrayList<Character> getAll(Integer pageNumber, Integer pageSize) throws NotFoundException, InternalServerErrorException;
}
