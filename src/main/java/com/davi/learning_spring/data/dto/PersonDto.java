package com.davi.learning_spring.data.dto;

import java.io.Serializable;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Table(name = "person")
public class PersonDto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String firstName;
    private String lastName;
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