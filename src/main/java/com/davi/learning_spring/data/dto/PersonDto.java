package com.davi.learning_spring.data.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.davi.learning_spring.serializer.GenderSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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

    @JsonSerialize(using = GenderSerializer.class)
    private String gender;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDay;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String phoneNumber;

    public PersonDto(){}

    public PersonDto (Long id, String firstName, String lastName, String address, String gender, LocalDate birthDay){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.birthDay = birthDay;
    }

}