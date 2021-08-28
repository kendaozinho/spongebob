package com.luizalabs.spongebob.entrypoint.api.v1.character.response;

import com.luizalabs.spongebob.domain.entity.Character;
import lombok.*;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetCharacterByFilterEndpointResponse {
    private MetaEndpointResponse meta;
    private ArrayList<CharacterEndpointResponse> characters;

    public GetCharacterByFilterEndpointResponse(ArrayList<Character> characters, Integer pageNumber, Integer pageSize) {
        this.meta = new MetaEndpointResponse(pageNumber, pageSize);
        this.characters = characters.stream().map(character ->
                new CharacterEndpointResponse(character.getId(), character.getName(), character.getDescription())
        ).collect(Collectors.toCollection(ArrayList::new));
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class MetaEndpointResponse {
        private Integer offset;
        private Integer limit;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class CharacterEndpointResponse {
        private UUID id;
        private String name;
        private String description;
    }
}

