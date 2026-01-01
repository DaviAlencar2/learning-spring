package com.davi.learning_spring.services;

import com.davi.learning_spring.exception.ResourceNotFoundException;
import static com.davi.learning_spring.mapper.ObjectMapper.parseListObjects;
import static com.davi.learning_spring.mapper.ObjectMapper.parseObject;
import com.davi.learning_spring.data.dto.PersonDto;
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


    public PersonDto findByID(Long id){
        logger.info("Finding one person!");
        var entity = repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No records found for this id"));
        return parseObject(entity, PersonDto.class);
    }


    public List<PersonDto> findAll(){
        logger.info("Finding ALL people!");
        return parseListObjects(repository.findAll(), PersonDto.class);
    }


    public PersonDto create(PersonDto person){
        logger.info("Creating person");
        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDto.class);
    }


    public void delete(Long id){
        logger.info("Deleting person!");
        Person person = repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(person);
    }


    public PersonDto update(PersonDto person){
        logger.info("Updating person");

        Person storedPerson = repository.findById(person.getId()).orElseThrow(
            () -> new ResourceNotFoundException("No records found for this id"));
        
        PersonDto storedPersonDto = parseObject(storedPerson, PersonDto.class);

        for (var field : PersonDto.class.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object newValue = field.get(person);
                if (newValue != null && !field.getName().equals("id")) {
                    System.out.println("Entrou no if de update" + field.getName() + " = " + newValue);
                    field.set(storedPersonDto, newValue);
                }
            } catch (IllegalAccessException e) {
                logger.warn("Failed to access field: " + field.getName());
            }
        }

        storedPerson = parseObject(storedPersonDto, Person.class);

        return parseObject(repository.save(storedPerson), PersonDto.class);
    }
}