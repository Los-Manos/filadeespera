package br.com.fila.app.filadeespera.mapper;

import org.modelmapper.ModelMapper;

import br.com.fila.app.filadeespera.model.dto.PersonDto;
import br.com.fila.app.filadeespera.model.entity.Person;

public class PersonConfigMapper {
    
    private PersonConfigMapper(){};

    private static final ModelMapper modelMapper = new ModelMapper(){};

    public static Person convertToEntity (PersonDto personDto){
        return modelMapper.map(personDto, Person.class);
    }

     public static PersonDto convertToDto (Person person){
        return modelMapper.map(person, PersonDto.class);
    }

}
