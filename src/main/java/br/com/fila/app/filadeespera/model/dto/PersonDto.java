package br.com.fila.app.filadeespera.model.dto;

import java.util.Date;

import br.com.fila.app.filadeespera.model.enums.PersonType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto {
    
    private Long id;
    private String name;
    private Date bith;
    private String email;
    private String telephone;
    private String cpf;
    private String sus;
    private PersonType personType;

}
