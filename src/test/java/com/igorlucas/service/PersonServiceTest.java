package com.igorlucas.service;

import static com.igorlucas.utils.PersonUtils.createFakeDTO;
import static com.igorlucas.utils.PersonUtils.createFakeEntity;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.igorlucas.dto.mapper.PersonMapper;
import com.igorlucas.dto.request.PersonDTO;
import com.igorlucas.dto.response.MessageResponseDTO;
import com.igorlucas.entities.Person;
import com.igorlucas.repositories.PersonRepository;
import com.igorlucas.services.PersonService;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	@Mock
	private PersonRepository personRepository;
	
    @Mock
    private PersonMapper personMapper;
	
	@InjectMocks
	private PersonService personService;
	
	@Test
	void testGivenPersonDTOThenReturnSavedMessage() {
		PersonDTO personDTO = createFakeDTO();
		Person expectedSavedPerson = createFakeEntity();
		
		when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);
		
		MessageResponseDTO expectedSuccessMessage = createExpectedMethodResponse("Saved", expectedSavedPerson.getId());
		
		MessageResponseDTO successMessage = personService.insert(personDTO);
		
		Assertions.assertEquals(expectedSuccessMessage, successMessage);
		
	}

	private MessageResponseDTO createExpectedMethodResponse(String operation, Long id) {
		return MessageResponseDTO.builder()
				.message(operation + " person with ID " + id)
				.build();
	}
	
}
