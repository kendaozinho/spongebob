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
@Builder
@EqualsAndHashCode
@ToString
@Schema
public class CharacterEndpointRequest {
    @NotNull
    @NotBlank
    @Schema(required = true, description = "Name", example = "SpongeBob SquarePants")
    private String name;

    @Schema(description = "Description", example = "A talking sponge")
    private String description;

    @Schema(description = "Image", example = "https://www.image.com/spongebob.png")
    private String image;

    public Character toEntity() {
        Character character = new Character();
        character.setName(this.getName());
        character.setDescription(this.getDescription());
        character.setImage(this.getImage());
        return character;
    }
}

