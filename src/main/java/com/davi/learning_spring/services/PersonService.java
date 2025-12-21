package com.davi.learning_spring.services;

import com.davi.learning_spring.model.Person;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

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

}
