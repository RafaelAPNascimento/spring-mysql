package com.finalexception.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.finalexception.domain.Person;

@Component
public interface PersonRepository extends JpaRepository<Person, Long>{

}
