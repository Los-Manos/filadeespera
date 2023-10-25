// package br.com.fila.app.filadeespera.data;

// import java.time.LocalDate;
// import java.util.Optional;

// import br.com.fila.app.filadeespera.model.entity.Person;
// import lombok.AccessLevel;
// import lombok.NoArgsConstructor;

// @NoArgsConstructor(access = AccessLevel.PRIVATE)
// public class PersonSeviceImplMocks {

//     public static Person fullPersonDataMock() {
//         var person = Person.builder()
//                 .id(1L)
//                 .name("Daniel")
//                 .bith(LocalDate.of(1994, 5, 11))
//                 .cpf("13599177724")
//                 .email("daniel.vdg@hotmail.com")
//                 .sus("1484946848618")
//                 .build();

//         return person;
//     }


//      public static Optional<Person> fullOptinalPersonDataMock() {
//         Optional<Person> person = Optional.of(Person.builder()
//                 .id(1L)
//                 .name("Daniel")
//                 .bith(LocalDate.of(1994, 5, 11))
//                 .cpf("13599177724")
//                 .email("daniel.vdg@hotmail.com")
//                 .sus("1484946848618")
//                 .build());

//         return person;
//     }

    
//     public static Person personNullDataMock() {
//         var person = Person.builder()
//                 .id(null)
//                 .name(null)
//                 .bith(LocalDate.now())
//                 .cpf(null)
//                 .email(null)
//                 .sus(null)
//                 .build();

//         return person;
//     }

// }
