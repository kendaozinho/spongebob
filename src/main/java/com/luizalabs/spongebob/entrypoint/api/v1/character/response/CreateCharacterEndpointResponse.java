package com.luizalabs.spongebob.entrypoint.api.v1.character.response;

import java.util.UUID;

public class CreateCharacterEndpointResponse {
    private UUID id;
    private String name;
    private String description;

    public CreateCharacterEndpointResponse() {
    }

    public CreateCharacterEndpointResponse(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
