package com.igorlucas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igorlucas.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
