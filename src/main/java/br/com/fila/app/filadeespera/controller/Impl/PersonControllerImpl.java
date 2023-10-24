package br.com.fila.app.filadeespera.controller.impl;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fila.app.filadeespera.controller.PersonController;
import br.com.fila.app.filadeespera.mapper.PersonConfigMapper;
import br.com.fila.app.filadeespera.model.dto.PersonDTO;
import br.com.fila.app.filadeespera.model.entity.Person;
import br.com.fila.app.filadeespera.service.PersonService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@AllArgsConstructor
@RestController
@RequestMapping(path = "/persons")
public class PersonControllerImpl implements PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PersonDTO personDTO){
       
        Person person = personService.save(personDTOConvertToEntity(personDTO));
        return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(person.getId())
                    .toUri()
        ).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Person>findById(@PathVariable("id") Long id) {
        Person person = personService.findById(id);
        return ResponseEntity.ok(person);
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(personService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable String id, @RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok(personService.update(personDTOConvertToEntity(personDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(personService.delete(id));
    }
    
    private Person personDTOConvertToEntity(PersonDTO personDTO) {
     return PersonConfigMapper.convertToEntity(personDTO);
    }
    
}
