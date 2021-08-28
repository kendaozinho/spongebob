package com.luizalabs.spongebob.entrypoint.api.v1.character.response;

import com.luizalabs.spongebob.domain.entity.Character;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

public class GetCharacterByFilterEndpointResponse {
    private MetaEndpointResponse meta;
    private ArrayList<CharacterEndpointResponse> characters;

    public GetCharacterByFilterEndpointResponse() {
    }

    public GetCharacterByFilterEndpointResponse(ArrayList<Character> characters, Integer pageNumber, Integer pageSize) {
        this.meta = new MetaEndpointResponse(pageNumber, pageSize);
        this.characters = characters.stream().map(character ->
                new CharacterEndpointResponse(character.getId(), character.getName(), character.getDescription())
        ).collect(Collectors.toCollection(ArrayList::new));
    }

    public MetaEndpointResponse getMeta() {
        return this.meta;
    }

    public ArrayList<CharacterEndpointResponse> getCharacters() {
        return this.characters;
    }

    public static class MetaEndpointResponse {
        private Integer offset;
        private Integer limit;

        public MetaEndpointResponse() {
        }

        public MetaEndpointResponse(Integer offset, Integer limit) {
            this.offset = offset;
            this.limit = limit;
        }

        public Integer getOffset() {
            return this.offset;
        }

        public Integer getLimit() {
            return this.limit;
        }
    }

    public static class CharacterEndpointResponse {
        private UUID id;
        private String name;
        private String description;

        public CharacterEndpointResponse() {
        }

        public CharacterEndpointResponse(UUID id, String name, String description) {
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
}

