package com.davi.learning_spring.services;

import com.davi.learning_spring.model.Person;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findByID(String id){
        logger.info("Finding onie person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Davi");
        person.setLastName("Bezerra");
        person.setAddress("João Pessoa - PB - Brasil");
        person.setGender("Male");

        return person;
    }

    public List<Person> findAll(){
        List<Person> persons = new ArrayList<Person>();

        for (int i = 0; i < 8; i++) {
            Person person = new Person();
            person.setId(counter.incrementAndGet());
            person.setFirstName("Person Name " + i);
            person.setLastName("Last Name " + i);
            person.setAddress("Some Address in Brasil " + i);
            person.setGender(i % 2 == 0 ? "Male" : "Female");
            persons.add(person);
        }
        
        return persons;
    }
}