package br.com.fila.app.filadeespera.mapper;

import org.modelmapper.ModelMapper;

import br.com.fila.app.filadeespera.model.dto.PersonDTO;
import br.com.fila.app.filadeespera.model.entity.Person;

public class PersonConfigMapper {
    
    private PersonConfigMapper(){}

    private static final ModelMapper modelMapper = new ModelMapper(){};

    public static Person convertToEntity (PersonDTO personDTO){
        return modelMapper.map(personDTO, Person.class);
    }

     public static PersonDTO convertToDTO (Person person){
        return modelMapper.map(person, PersonDTO.class);
    }

}
