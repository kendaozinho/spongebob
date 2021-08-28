package com.luizalabs.spongebob.domain.entity;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Character {
    private UUID id;
    private String name;
    private String description;
}
