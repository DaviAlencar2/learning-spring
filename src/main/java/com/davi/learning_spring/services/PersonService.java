package com.davi.learning_spring.services;

import com.davi.learning_spring.exception.ResourceNotFoundException;
import com.davi.learning_spring.model.Person;
import com.davi.learning_spring.repository.PersonRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());


    public Person findByID(Long id){
        logger.info("Finding one person!");
        return repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No records found for this id"));
    }


    public List<Person> findAll(){
        logger.info("Finding ALL people!");
        return repository.findAll();
    }


    public Person create(Person person){
        logger.info("Creating person");
        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("Deleting person!");
        Person person = repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(person);
    }

    public Person update(Person person){
        logger.info("Updating person");
        Person storedPerson = repository.findById(person.getId()).orElseThrow(
            () -> new ResourceNotFoundException("No records found for this id"));
        for (var field : Person.class.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object newValue = field.get(person);
                if (newValue != null) {
                    field.set(storedPerson, newValue);
                }
            } catch (IllegalAccessException e) {
                logger.warn("Failed to access field: " + field.getName());
            }
        }
        return repository.save(storedPerson);
    }
}