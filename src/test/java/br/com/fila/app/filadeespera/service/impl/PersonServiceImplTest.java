package br.com.fila.app.filadeespera.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.fila.app.filadeespera.exception.BusinessException;
import br.com.fila.app.filadeespera.model.entity.Person;
import br.com.fila.app.filadeespera.repository.PersonRepository;
import br.com.fila.app.filadeespera.service.PersonService;

@SpringBootTest
class PersonServiceImplTest {

    private static final String EMAIL = "daniel.vdg@hotmail.com";

    private static final String CPF = "13599177724";

    private static final LocalDate BITH = LocalDate.of(1994, 5, 11);

    private static final String NAME = "Daniel";

    @InjectMocks
    private PersonServiceImpl personServiceImpl;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonService personService;

    Person person;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        startPerson();
    }

    @Test
    void shouldCreatePersonWithSuccess() {
        personRepository.save(person);
        verify(personRepository, times(1)).save(person);
        verifyNoMoreInteractions(personRepository);
        when(personServiceImpl.save(person)).thenReturn(person);
        Person personCurrent = personRepository.save(person);
        assertEquals(person, personCurrent);
    }

    @Test
    void shouldThrowBusinessExceptionWhenNotSave() {        
        when(personRepository.save(person)).thenThrow(new BusinessException("Erro ao salvar person"));
        BusinessException businessException  = assertThrows(
            BusinessException.class, 
            () -> personServiceImpl.save(person)
        );
        verify(personRepository,times(1)).save(person);
        assertEquals("Erro ao salvar person", businessException.getMessage());
    }

    void startPerson() {
        new Person();
        person = Person.builder()
                .name(NAME)
                .bith(BITH)
                .cpf(CPF)
                .email(EMAIL)
                .build();
    }

}
