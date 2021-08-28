package com.luizalabs.spongebob.entrypoint.api.v1.character.response;

import com.luizalabs.spongebob.domain.entity.Character;

import java.util.UUID;

public class GetCharacterByIdEndpointResponse {
    private UUID id;
    private String name;
    private String description;

    public GetCharacterByIdEndpointResponse() {
    }

    public GetCharacterByIdEndpointResponse(Character character) {
        this.id = character.getId();
        this.name = character.getName();
        this.description = character.getDescription();
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
