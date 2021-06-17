package com.igorlucas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igorlucas.dto.mapper.PersonMapper;
import com.igorlucas.dto.request.PersonDTO;
import com.igorlucas.dto.response.MessageResponseDTO;
import com.igorlucas.entities.Person;
import com.igorlucas.repositories.PersonRepository;

@Service
public class PersonService {
	
	private final PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public Person findById(Long id) {
		Optional<Person> person = personRepository.findById(id);
		return person.get();
	}
	
	public MessageResponseDTO insert(PersonDTO personDto) {
		Person person = personMapper.toModel(personDto);
		Person savedPerson = personRepository.save(person);
		return MessageResponseDTO.
				builder()
				.message("Saved person with ID " + savedPerson.getId())
				.build();
	}

}
