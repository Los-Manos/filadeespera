package br.com.fila.app.filadeespera.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fila.app.filadeespera.model.entity.Person;

public interface PersonRepository extends CrudRepository <Person , Long> {

}
