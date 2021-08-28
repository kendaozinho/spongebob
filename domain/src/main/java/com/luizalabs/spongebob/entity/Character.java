package com.luizalabs.spongebob.entity;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Character {
    private UUID id;
    private String name;
    private String description;
    private String image;
}
