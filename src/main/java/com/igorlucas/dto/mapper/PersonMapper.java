package com.igorlucas.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.igorlucas.dto.request.PersonDTO;
import com.igorlucas.entities.Person;


@Mapper(componentModel = "spring")
public interface PersonMapper {
	
	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
	
	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "yyyy-MM-dd")
	Person toModel(PersonDTO personDTO);
	
	PersonDTO toDTO(Person person);

}
