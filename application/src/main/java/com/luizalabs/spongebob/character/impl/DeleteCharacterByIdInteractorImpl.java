package com.luizalabs.spongebob.application.character.impl;

import com.luizalabs.spongebob.domain.gateway.character.DeleteCharacterByIdGateway;
import com.luizalabs.spongebob.domain.interactor.character.DeleteCharacterByIdInteractor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
    public void execute(UUID id) {
        this.deleteCharacterByIdGateway.deleteOneById(id);
    }
}
