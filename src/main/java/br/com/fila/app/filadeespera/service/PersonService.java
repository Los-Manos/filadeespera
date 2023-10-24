package br.com.fila.app.filadeespera.service;

import java.util.List;

import br.com.fila.app.filadeespera.model.entity.Person;

public interface PersonService {
    
    Person save(Person person);
    
    Person findById(Long id);

    List<Person> findAll();

    Person update(Person person);

    String delete(Long id);

}
