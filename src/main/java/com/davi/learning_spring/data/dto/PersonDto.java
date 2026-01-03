package com.davi.learning_spring.data.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;


// A maneira como o proprio spring e a jvm define a ordem de exibicao dos campos do json é um pouco confusa e dependendo do contexto dificil de prever para isso usar essa funcionalidade do jackson garante a ordem desejada de exibicao dos campos
@JsonPropertyOrder({"id", "firstName", "lastName", "address", "gender"}) //Jackson 2.12+ (Spring Boot 2.5+, incluindo Spring Boot 3.x)Você pode usar AMBOS - tanto o nome da variável Java quanto o nome JSON customizado:
@Data
public class PersonDto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonIgnore
    private String address;
    private String gender;

    public PersonDto(){}

    public PersonDto (Long id, String firstName, String lastName, String address, String gender){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

}