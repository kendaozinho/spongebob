package com.luizalabs.spongebob.character.impl;

import com.luizalabs.spongebob.entity.Character;
import com.luizalabs.spongebob.gateway.character.GetCharacterByIdGateway;
import com.luizalabs.spongebob.interactor.character.GetCharacterByIdInteractor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetCharacterByIdInteractorImpl implements GetCharacterByIdInteractor {
    private final GetCharacterByIdGateway getCharacterByIdGateway;

    public GetCharacterByIdInteractorImpl(
            GetCharacterByIdGateway getCharacterByIdGateway
    ) {
        this.getCharacterByIdGateway = getCharacterByIdGateway;
    }

    @Override
    public Character execute(UUID id) {
        return this.getCharacterByIdGateway.getOneById(id);
    }
}
