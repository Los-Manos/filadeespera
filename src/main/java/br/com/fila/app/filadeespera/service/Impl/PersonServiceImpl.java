package br.com.fila.app.filadeespera.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

  private final static Logger logger = LogManager.getLogger("PersonServiceImpl");

  @Autowired
  private PersonRepository personRepository;

  public Person save(Person person) {

    if (null == person) {
      throw new BusinessException("Error ao salvar person");
    }
    logger.info("save person email = {}", person.getEmail());
    return personRepository.save(person);
  } 

  public Person findById(Long id){
    Optional<Person> personId = personRepository.findById(id);

    return personId.orElseThrow(() ->( new BusinessException("id do person não encontrado")));
  }

  public List<Person> findAll(){
    return (List<Person>) personRepository.findAll();
  }

  public Person update(Person person){

    person.setName(person.getName());
    person.setEmail(person.getEmail());
    person.setBith(person.getBith());
    person.setCpf(person.getCpf());
    person.setSus(person.getSus());
    person.setTelephone(person.getTelephone());
    person.setPersonType(person.getPersonType());

    return personRepository.save(person);
  }

  public String delete(Long id) {

    if (null == id) {
      throw new BusinessException("Erro ao deletar person");
    }
    personRepository.deleteById(id);
    
    return String.format("O %d deletado com sucesso", id);
  }

}
