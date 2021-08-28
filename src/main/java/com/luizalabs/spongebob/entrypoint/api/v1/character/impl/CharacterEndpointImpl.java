package com.luizalabs.spongebob.entrypoint.api.v1.character.impl;

import com.luizalabs.spongebob.domain.entity.Character;
import com.luizalabs.spongebob.domain.interactor.character.*;
import com.luizalabs.spongebob.entrypoint.api.v1.character.request.CreateCharacterEndpointRequest;
import com.luizalabs.spongebob.entrypoint.api.v1.character.request.UpdateCharacterEndpointRequest;
import com.luizalabs.spongebob.entrypoint.api.v1.character.response.CreateCharacterEndpointResponse;
import com.luizalabs.spongebob.entrypoint.api.v1.character.response.GetCharacterByFilterEndpointResponse;
import com.luizalabs.spongebob.entrypoint.api.v1.character.response.GetCharacterByIdEndpointResponse;
import com.luizalabs.spongebob.entrypoint.api.v1.character.response.UpdateCharacterEndpointResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/v1/characters")
@Tag(name = "Character Endpoint", description = "/v1/characters")
public class CharacterEndpointImpl {
    private final GetCharacterByIdInteractor getCharacterByIdInteractor;
    private final GetCharactersByFilterInteractor getCharactersByFilterInteractor;
    private final CreateCharacterInteractor createCharacterInteractor;
    private final UpdateCharacterByIdInteractor updateCharacterByIdInteractor;
    private final DeleteCharacterByIdInteractor deleteCharacterByIdInteractor;

    public CharacterEndpointImpl(
            GetCharacterByIdInteractor getCharacterByIdInteractor,
            GetCharactersByFilterInteractor getCharactersByFilterInteractor,
            CreateCharacterInteractor createCharacterInteractor,
            UpdateCharacterByIdInteractor updateCharacterByIdInteractor,
            DeleteCharacterByIdInteractor deleteCharacterByIdInteractor
    ) {
        this.getCharacterByIdInteractor = getCharacterByIdInteractor;
        this.getCharactersByFilterInteractor = getCharactersByFilterInteractor;
        this.createCharacterInteractor = createCharacterInteractor;
        this.updateCharacterByIdInteractor = updateCharacterByIdInteractor;
        this.deleteCharacterByIdInteractor = deleteCharacterByIdInteractor;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get Character(s)")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "400", description = "Invalid id | Invalid offset | Invalid limit"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Character(s) not found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public GetCharacterByFilterEndpointResponse getByFilter(
            @RequestParam(required = false) @Parameter(name = "id", description = "id") UUID id,
            @RequestParam(required = false) @Parameter(name = "name", description = "name") String name,
            @RequestParam(required = false, defaultValue = "1") @Parameter(name = "offset", description = "page number") @Min(1) Integer offset,
            @RequestParam(required = false, defaultValue = "10") @Parameter(name = "limit", description = "page size") @Min(1) Integer limit
    ) {
        return new GetCharacterByFilterEndpointResponse(
                this.getCharactersByFilterInteractor.execute(id, name, offset, limit),
                offset, limit
        );
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get Character")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "400", description = "Invalid id"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Character not found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error"),
                    @ApiResponse(responseCode = "502", description = "Bad Gateway")
            }
    )
    public GetCharacterByIdEndpointResponse getById(
            @PathVariable @Parameter(name = "id", description = "id") UUID id
    ) {
        Character character = this.getCharacterByIdInteractor.execute(id);
        return new GetCharacterByIdEndpointResponse(
                character.getId(), character.getName(), character.getDescription()
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create Character")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Created"),
                    @ApiResponse(responseCode = "400", description = "Invalid Request Body"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "409", description = "Name already exists"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public CreateCharacterEndpointResponse post(@RequestBody @Valid CreateCharacterEndpointRequest request) {
        Character character = this.createCharacterInteractor.execute(request.toEntity());
        return new CreateCharacterEndpointResponse(character.getId(), character.getName(), character.getDescription());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update Character")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "400", description = "Invalid id | Invalid Request Body"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Character not found"),
                    @ApiResponse(responseCode = "409", description = "Name already exists"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public UpdateCharacterEndpointResponse put(
            @PathVariable @Parameter(name = "id", description = "id") UUID id,
            @RequestBody @Valid UpdateCharacterEndpointRequest request
    ) {
        Character character = this.updateCharacterByIdInteractor.execute(id, request.toEntity());
        return new UpdateCharacterEndpointResponse(character.getId(), character.getName(), character.getDescription());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete Character")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "No Content"),
                    @ApiResponse(responseCode = "400", description = "Invalid id"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Character not found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public void delete(@PathVariable @Parameter(name = "id", description = "id") UUID id) {
        this.deleteCharacterByIdInteractor.execute(id);
    }
}
