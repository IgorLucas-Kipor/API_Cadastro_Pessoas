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
		personRepository.save(person);
		return generateResponse("Saved", person.getId());
	}
	
	public void deleteById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);
		personRepository.delete(person);
	}
	
	public MessageResponseDTO updateById(Long id, PersonDTO personDto) throws PersonNotFoundException {
		verifyIfExists(id);
		Person personToUpdate = personMapper.toModel(personDto);
		personToUpdate.setId(id);
		personRepository.save(personToUpdate);
		return generateResponse("Updated", personToUpdate.getId());
	}

	private MessageResponseDTO generateResponse(String operation, Long id) {
		return MessageResponseDTO.
				builder()
				.message(operation + " person with ID " + id)
				.build();
	}
	
	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return personRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException(id));
	}

}
