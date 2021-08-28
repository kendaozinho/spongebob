package com.luizalabs.spongebob.character.impl;

import com.luizalabs.spongebob.gateway.character.DeleteCharacterByIdGateway;
import com.luizalabs.spongebob.interactor.character.DeleteCharacterByIdInteractor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCharacterByIdInteractorImpl implements DeleteCharacterByIdInteractor {
    private final DeleteCharacterByIdGateway deleteCharacterByIdGateway;

    public DeleteCharacterByIdInteractorImpl(
            DeleteCharacterByIdGateway deleteCharacterByIdGateway
    ) {
        this.deleteCharacterByIdGateway = deleteCharacterByIdGateway;
    }

    @Override
    public void execute(UUID id) {
        this.deleteCharacterByIdGateway.deleteOneById(id);
    }
}
