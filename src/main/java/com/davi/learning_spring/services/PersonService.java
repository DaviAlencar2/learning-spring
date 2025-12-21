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
    List<Person> persons = new ArrayList<Person>();


    public Person findByID(String id){
        logger.info("Finding one person!");
        for (Person person : persons) {
            if (person.getId().toString().equals(id)) {
                return person;
            }
        }
        return null;
    }


    public List<Person> findAll(){
        logger.info("Finding ALL people!");
        return persons;
    }


    public Person create(Person person){
        logger.info("Creating person");
        person.setId(counter.incrementAndGet());
        persons.add(person);
        return person;
    }

    public void delete(String id){
        logger.info("Deleting person!");
        persons.removeIf(person -> person.getId().toString().equals(id));
    }

    public Person update(Person person){
        logger.info("Updating person");
        for (int i = 0; i < persons.size(); i++) {
            Person p = persons.get(i);
            if (p.getId().equals(person.getId())) {
                persons.set(i, person);
                break;
            }
        }
        return person;
    }
}