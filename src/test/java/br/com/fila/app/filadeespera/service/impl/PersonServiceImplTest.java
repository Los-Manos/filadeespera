package br.com.fila.app.filadeespera.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.fila.app.filadeespera.data.PersonSeviceImplMocks;
import br.com.fila.app.filadeespera.exception.BusinessException;
import br.com.fila.app.filadeespera.model.entity.Person;
import br.com.fila.app.filadeespera.repository.PersonRepository;
import br.com.fila.app.filadeespera.service.PersonService;
import lombok.var;

@SpringBootTest
class PersonServiceImplTest {

    
    @InjectMocks
    private PersonServiceImpl personServiceImpl;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonService personService;

    Person person;
    
    @Test
    void shouldCreatePersonWithSuccess() {
        var person = PersonSeviceImplMocks.fullPersonDataMock();
        personRepository.save(person);
        verify(personRepository, times(1)).save(person);
        verifyNoMoreInteractions(personRepository);
        when(personServiceImpl.save(person)).thenReturn(person);
        Person personCurrent = personRepository.save(person);
        assertEquals(person, personCurrent);
    }

    @Test
    void shouldThrowBusinessExceptionWhenNotSave() {        
        when(personRepository.save(person)).
                thenThrow(new BusinessException("Erro ao salvar person"));
        
        BusinessException businessException  = assertThrows(
                BusinessException.class, 
                () -> personServiceImpl.save(person)
        );
        
        verify(personRepository,times(0)).save(person);
        assertEquals("Erro ao salvar person", businessException.getMessage());
    }

    @Test
    void shouldFindByIdPersonWithSucess(){
        var personOptinal = PersonSeviceImplMocks.fullOptinalPersonDataMock();
        when(personRepository.findById(anyLong())).thenReturn(personOptinal);
        verify(personRepository,times(0)).findById(anyLong());
        verifyNoMoreInteractions(personRepository);
        Person response = personServiceImpl.findById(anyLong());
        assertNotNull(response);
        assertEquals(Person.class,response.getClass());
    }
    
    @Test
    void shouldThrowBusinessExcptionWhenPersonIdIsEmpty(){
       
        when(personRepository.findById(anyLong()))
                .thenThrow(BusinessException.class);
       
        BusinessException businessExceptionFindById = assertThrows
                (BusinessException.class,
                ()-> personServiceImpl.findById(null)
        );

       assertEquals("id do person não encontrado", businessExceptionFindById.getMessage());
        
    }

    
}
