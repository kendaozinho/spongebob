package com.luizalabs.spongebob.character.impl;

import com.luizalabs.spongebob.entity.Character;
import com.luizalabs.spongebob.gateway.character.GetAllCharactersGateway;
import com.luizalabs.spongebob.gateway.character.GetCharacterByIdGateway;
import com.luizalabs.spongebob.gateway.character.GetCharactersByNameGateway;
import com.luizalabs.spongebob.interactor.character.GetCharactersByFilterInteractor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

@Service
public class GetCharactersByFilterInteractorImpl implements GetCharactersByFilterInteractor {
    private final GetCharacterByIdGateway getCharacterByIdGateway;
    private final GetCharactersByNameGateway getCharactersByNameGateway;
    private final GetAllCharactersGateway getAllCharactersGateway;

    public GetCharactersByFilterInteractorImpl(
            GetCharacterByIdGateway getCharacterByIdGateway,
            GetCharactersByNameGateway getCharactersByNameGateway,
            GetAllCharactersGateway getAllCharactersGateway
    ) {
        this.getCharacterByIdGateway = getCharacterByIdGateway;
        this.getCharactersByNameGateway = getCharactersByNameGateway;
        this.getAllCharactersGateway = getAllCharactersGateway;
    }

    @Override
    public ArrayList<Character> execute(UUID id, String name, Integer pageNumber, Integer pageSize) {
        if (id != null) {
            return new ArrayList<>(
                    Collections.singletonList(this.getCharacterByIdGateway.getOneById(id))
            );
        } else if (name != null) {
            return this.getCharactersByNameGateway.getAllByName(name, pageNumber, pageSize);
        } else {
            return this.getAllCharactersGateway.getAll(pageNumber, pageSize);
        }
    }
}
