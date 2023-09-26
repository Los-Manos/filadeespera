package br.com.fila.app.filadeespera.controller.Impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fila.app.filadeespera.controller.PersonController;
import br.com.fila.app.filadeespera.mapper.PersonConfigMapper;
import br.com.fila.app.filadeespera.model.dto.PersonDto;
import br.com.fila.app.filadeespera.model.entity.Person;
import br.com.fila.app.filadeespera.service.PersonService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/persons")
public class PersonControllerImpl implements PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PersonDto personDto){
       
        Person person = PersonConfigMapper.convertToEntity(personDto);        
           person = personService.save(person);
           return ResponseEntity.created(
               ServletUriComponentsBuilder.fromCurrentRequest()
                       .path("/{id}")
                       .buildAndExpand(person.getId())
                       .toUri()
           ).build();

    }
}
