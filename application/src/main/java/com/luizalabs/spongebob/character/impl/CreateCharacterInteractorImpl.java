package com.luizalabs.spongebob.character.impl;

import com.luizalabs.spongebob.entity.Character;
import com.luizalabs.spongebob.gateway.character.CreateCharacterGateway;
import com.luizalabs.spongebob.interactor.character.CreateCharacterInteractor;
import org.springframework.stereotype.Service;

@Service
public class CreateCharacterInteractorImpl implements CreateCharacterInteractor {
    private final CreateCharacterGateway createCharacterGateway;

    public CreateCharacterInteractorImpl(CreateCharacterGateway createCharacterGateway) {
        this.createCharacterGateway = createCharacterGateway;
    }

    @Override
    public Character execute(Character request) {
        return this.createCharacterGateway.create(request);
    }
}
