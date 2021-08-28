package com.luizalabs.spongebob.entrypoint.api.v1.character.request;

import com.luizalabs.spongebob.domain.entity.Character;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema
public class CreateCharacterEndpointRequest {
    @NotNull
    @NotBlank
    @Schema(required = true, description = "Name", example = "Kenneth Gottschalk de Azevedo")
    private String name;

    @NotNull
    @NotBlank
    @Schema(required = true, description = "Description", example = "kendao@luizalabs.com")
    private String description;

    public Character toEntity() {
        Character character = new Character();
        character.setName(this.getName());
        character.setDescription(this.getDescription());
        return character;
    }
}

