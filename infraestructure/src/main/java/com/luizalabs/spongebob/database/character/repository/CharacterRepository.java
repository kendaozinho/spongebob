package com.luizalabs.spongebob.database.character.repository;

import com.luizalabs.spongebob.database.character.table.CharacterTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterTable, UUID> {
    CharacterTable findOneById(UUID id);

    CharacterTable findOneByName(String name);

    Page<CharacterTable> findAllByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<CharacterTable> findAll(Pageable pageable);
}
