package com.davi.learning_spring.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Person implements Serializable{
    private static final long serialVersionUID = 1L;
     
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public Person(){}

    public Person (Long id, String firstName, String lastName, String address, String gender){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

}