package com.luizalabs.spongebob.application.character.impl;

import com.luizalabs.spongebob.domain.entity.Character;
import com.luizalabs.spongebob.domain.gateway.character.UpdateCharacterByIdGateway;
import com.luizalabs.spongebob.domain.interactor.character.UpdateCharacterByIdInteractor;
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
