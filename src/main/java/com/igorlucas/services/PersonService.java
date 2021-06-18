package com.igorlucas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igorlucas.dto.mapper.PersonMapper;
import com.igorlucas.dto.request.PersonDTO;
import com.igorlucas.dto.response.MessageResponseDTO;
import com.igorlucas.entities.Person;
import com.igorlucas.exception.PersonNotFoundException;
import com.igorlucas.repositories.PersonRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
	
	private final PersonRepository personRepository;
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;
	
	public List<PersonDTO> findAll() {
		List<Person> people = personRepository.findAll();
		return people
				.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	public PersonDTO findById(Long id) throws PersonNotFoundException{
		Person person = verifyIfExists(id);
		return personMapper.toDTO(person);
	}
	
	public MessageResponseDTO insert(PersonDTO personDto) {
		Person person = personMapper.toModel(personDto);
		Person savedPerson = personRepository.save(person);
		return MessageResponseDTO.
				builder()
				.message("Saved person with ID " + savedPerson.getId())
				.build();
	}
	
	public void deleteById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);
		personRepository.delete(person);
	}
	
	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return personRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException(id));
	}

}
