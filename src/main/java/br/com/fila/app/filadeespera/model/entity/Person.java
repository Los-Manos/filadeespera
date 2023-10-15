package br.com.fila.app.filadeespera.model.entity;

import java.time.LocalDate;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;


import br.com.fila.app.filadeespera.model.enums.PersonType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank
    @NotNull
    private String name;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate bith;
    
    @Email
    private String email;
    
    @NotNull
    private String telephone;
    
    @CPF
    private String cpf;
    
    @NotNull
    private String sus;
    
    @Enumerated(EnumType.STRING)
    private PersonType personType; 
}
