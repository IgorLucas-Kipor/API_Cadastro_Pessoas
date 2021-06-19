package com.igorlucas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.igorlucas.dto.request.PersonDTO;
import com.igorlucas.dto.response.MessageResponseDTO;
import com.igorlucas.exception.PersonNotFoundException;
import com.igorlucas.services.PersonService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {
	
	private PersonService service;
	
	@GetMapping
	public ResponseEntity<List<PersonDTO>> findAll() {
		List<PersonDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PersonDTO> findById(@PathVariable Long id) throws PersonNotFoundException {
		PersonDTO personDTO = service.findById(id);
		return ResponseEntity.ok(personDTO);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDto) {
		return service.insert(personDto);
	}
	
	@PutMapping(value = "/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDto) throws PersonNotFoundException {
		return service.updateById(id, personDto);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
		service.deleteById(id);
	}
	

}
