package br.com.fila.app.filadeespera.service.Impl;

import org.springframework.stereotype.Service;

import br.com.fila.app.filadeespera.model.entity.Person;
import br.com.fila.app.filadeespera.repository.PersonRepository;
import br.com.fila.app.filadeespera.service.PersonService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService  {
    
    private final PersonRepository personRepository;


 public Person save(Person person) {
    return personRepository.save(person);
 }


}
