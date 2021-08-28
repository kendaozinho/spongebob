package com.luizalabs.spongebob.entrypoint.api.v1.character.request;

import com.luizalabs.spongebob.domain.entity.Character;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Schema
public class UpdateCharacterEndpointRequest {
    @NotNull
    @NotBlank
    @Schema(required = true, description = "Name", example = "Kenneth Gottschalk de Azevedo")
    private String name;

    @NotNull
    @NotBlank
    @Schema(required = true, description = "Description", example = "kendao@luizalabs.com")
    private String description;

    public UpdateCharacterEndpointRequest() {
    }

    public UpdateCharacterEndpointRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Character toEntity() {
        Character character = new Character();
        character.setName(this.getName());
        character.setDescription(this.getDescription());
        return character;
    }
}
