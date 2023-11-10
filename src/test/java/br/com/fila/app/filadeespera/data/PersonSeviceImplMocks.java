package br.com.fila.app.filadeespera.data;

import java.time.LocalDate;
import java.util.Optional;

import br.com.fila.app.filadeespera.model.entity.Person;
import br.com.fila.app.filadeespera.model.enums.PersonType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonSeviceImplMocks {

    public static Person fullPersonDataMock() {

        return Person.builder()
                .id(1L)
                .name("Daniel")
                .bith(LocalDate.of(1994, 5, 11))
                .cpf("13599177724")
                .email("daniel.vdg@hotmail.com")
                .sus("1484946848618")
                .personType(PersonType.ADMIN)
                .build();
    }

     public static Optional<Person> fullOptinalPersonDataMock() {

         return Optional.of(Person.builder()
                .id(1L)
                .name("Daniel")
                .bith(LocalDate.of(1994, 5, 11))
                .cpf("13599177724")
                .email("daniel.vdg@hotmail.com")
                .sus("1484946848618")
                .build());
    }
    
    public static Person personNullDataMock() {
        return  Person.builder()
                .id(null)
                .name(null)
                .bith(LocalDate.now())
                .cpf(null)
                .email(null)
                .sus(null)
                .personType(PersonType.ACCOUNT)
                .build();

    }

}
