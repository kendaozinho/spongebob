package com.luizalabs.spongebob.application.character.impl;

import com.luizalabs.spongebob.domain.entity.Character;
import com.luizalabs.spongebob.domain.gateway.character.GetCharacterByIdGateway;
import com.luizalabs.spongebob.domain.interactor.character.GetCharacterByIdInteractor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
    public Character execute(UUID id) {
        return this.getCharacterByIdGateway.getOneById(id);
    }
}
