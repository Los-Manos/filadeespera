package br.com.fila.app.filadeespera.controller;

import org.springframework.http.ResponseEntity;
import br.com.fila.app.filadeespera.model.dto.PersonDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Person Controller", description = "Gerenciamento de pessoas cadastrada no sistema")
public interface PersonController {
    @Operation(summary = "Criação de uma nova pessoa cadastrada no sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201" , description = "Criação de cadastro criado com sucesso")
    })
    public ResponseEntity<Void> create(PersonDto personDto);

}
