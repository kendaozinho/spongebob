package com.luizalabs.spongebob.character.impl;

import com.luizalabs.spongebob.entity.Character;
import com.luizalabs.spongebob.gateway.character.UpdateCharacterByIdGateway;
import com.luizalabs.spongebob.interactor.character.UpdateCharacterByIdInteractor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateCharacterByIdByIdInteractorImpl implements UpdateCharacterByIdInteractor {
    private final UpdateCharacterByIdGateway updateCharacterByIdGateway;

    public UpdateCharacterByIdByIdInteractorImpl(
            UpdateCharacterByIdGateway updateCharacterByIdGateway
    ) {
        this.updateCharacterByIdGateway = updateCharacterByIdGateway;
    }

    @Override
    public Character execute(UUID id, Character request) {
        return this.updateCharacterByIdGateway.update(id, request);
    }
}
