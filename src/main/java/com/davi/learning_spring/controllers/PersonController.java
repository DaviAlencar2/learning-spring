package com.davi.learning_spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

import com.davi.learning_spring.model.Person;

import com.davi.learning_spring.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") Long id) {
        return personService.findByID(id);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return personService.findAll();
    }


    @PostMapping(
        value = "/create", 
        produces = MediaType.APPLICATION_JSON_VALUE, 
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Person create(@RequestBody Person personBody) {
        return personService.create(personBody);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping(
        value = "/update", 
        produces = MediaType.APPLICATION_JSON_VALUE, 
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Person update(@RequestBody Person personBody) {
        return personService.update(personBody);
    }

}
