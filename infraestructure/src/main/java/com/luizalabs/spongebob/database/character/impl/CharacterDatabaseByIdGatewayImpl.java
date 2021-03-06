package com.luizalabs.spongebob.database.character.impl;

import com.luizalabs.spongebob.entity.Character;
import com.luizalabs.spongebob.gateway.character.*;
import com.luizalabs.spongebob.database.character.exception.CharacterNameAlreadyExistsException;
import com.luizalabs.spongebob.database.character.exception.CharacterNotFoundException;
import com.luizalabs.spongebob.database.character.repository.CharacterRepository;
import com.luizalabs.spongebob.database.character.table.CharacterTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CharacterDatabaseByIdGatewayImpl implements
        GetCharacterByIdGateway,
        GetCharactersByNameGateway,
        GetAllCharactersGateway,
        CreateCharacterGateway,
        UpdateCharacterByIdGateway,
        DeleteCharacterByIdGateway {
    private final CharacterRepository repository;

    public CharacterDatabaseByIdGatewayImpl(CharacterRepository repository) {
        this.repository = repository;
    }

    @Override
    public Character getOneById(UUID id) throws CharacterNotFoundException {
        CharacterTable character = this.repository.findOneById(id);

        if (character == null) {
            throw new CharacterNotFoundException();
        }

        return character.toEntity();
    }

    @Override
    public ArrayList<Character> getAllByName(String name, Integer pageNumber, Integer pageSize) throws CharacterNotFoundException {
        Page<CharacterTable> characters =
                this.repository.findAllByNameContainingIgnoreCase(
                        name, PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Direction.ASC, "name"))
                );

        if (characters.isEmpty()) {
            throw new CharacterNotFoundException();
        }

        return characters.stream().map(CharacterTable::toEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public ArrayList<Character> getAll(Integer pageNumber, Integer pageSize) throws CharacterNotFoundException {
        Page<CharacterTable> characters = this.repository.findAll(
                PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Direction.ASC, "name"))
        );

        if (characters.isEmpty()) {
            throw new CharacterNotFoundException();
        }

        return characters.stream().map(CharacterTable::toEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Character create(Character request) throws CharacterNameAlreadyExistsException {
        CharacterTable character = this.repository.findOneByName(request.getName());

        if (character != null) {
            throw new CharacterNameAlreadyExistsException();
        }

        return this.repository.saveAndFlush(
                CharacterTable.builder()
                        .name(request.getName())
                        .description(request.getDescription())
                        .image(request.getImage())
                        .build()
        ).toEntity();
    }

    @Override
    public Character update(UUID id, Character request) throws CharacterNotFoundException, CharacterNameAlreadyExistsException {
        CharacterTable character = this.repository.findOneById(id);

        if (character == null) {
            throw new CharacterNotFoundException();
        }

        CharacterTable existingCharacter = this.repository.findOneByName(request.getName());

        if (existingCharacter != null && !existingCharacter.getId().equals(id)) {
            throw new CharacterNameAlreadyExistsException();
        }

        character.setName(request.getName());
        character.setDescription(request.getDescription());
        character.setImage(request.getImage());

        return this.repository.saveAndFlush(character).toEntity();
    }

    @Override
    public void deleteOneById(UUID id) throws CharacterNotFoundException {
        CharacterTable character = this.repository.findOneById(id);

        if (character == null) {
            throw new CharacterNotFoundException();
        }

        this.repository.delete(character);
    }
}
