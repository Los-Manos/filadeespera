package br.com.fila.app.filadeespera.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fila.app.filadeespera.exception.BusinessException;
import br.com.fila.app.filadeespera.model.entity.Person;
import br.com.fila.app.filadeespera.repository.PersonRepository;
import br.com.fila.app.filadeespera.service.PersonService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonRepository personRepository;

  public Person save(Person person) {

    if (null == person) {
      throw new BusinessException("Erro ao salvar person");
    }

    return personRepository.save(person);
  }

}
