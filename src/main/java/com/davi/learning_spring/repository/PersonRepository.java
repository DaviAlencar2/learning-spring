package com.davi.learning_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.davi.learning_spring.model.Person;

// antigamente era necessaio colocar um @repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
