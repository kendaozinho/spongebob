package com.luizalabs.spongebob.application.character.impl;

import com.luizalabs.spongebob.domain.entity.Character;
import com.luizalabs.spongebob.domain.gateway.character.CreateCharacterGateway;
import com.luizalabs.spongebob.domain.interactor.character.CreateCharacterInteractor;
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
