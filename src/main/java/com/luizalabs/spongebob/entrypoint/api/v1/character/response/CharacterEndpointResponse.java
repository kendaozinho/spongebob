package com.luizalabs.spongebob.entrypoint.api.v1.character.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class CharacterEndpointResponse {
    private UUID id;
    private String name;
    private String description;
    private String image;
}
