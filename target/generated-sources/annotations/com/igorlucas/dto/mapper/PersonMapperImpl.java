package com.igorlucas.dto.mapper;

import com.igorlucas.dto.request.PersonDTO;
import com.igorlucas.dto.request.PersonDTO.PersonDTOBuilder;
import com.igorlucas.entities.Person;
import com.igorlucas.entities.Person.PersonBuilder;
import com.igorlucas.entities.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T18:21:01-0300",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 15.0.2 (Oracle Corporation)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toModel(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        PersonBuilder person = Person.builder();

        person.birthDate( personDTO.getBirthDate() );
        person.cpf( personDTO.getCpf() );
        person.firstName( personDTO.getFirstName() );
        person.id( personDTO.getId() );
        person.lastName( personDTO.getLastName() );
        List<Phone> list = personDTO.getPhones();
        if ( list != null ) {
            person.phones( new ArrayList<Phone>( list ) );
        }

        return person.build();
    }

    @Override
    public PersonDTO toDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTOBuilder personDTO = PersonDTO.builder();

        personDTO.birthDate( person.getBirthDate() );
        personDTO.cpf( person.getCpf() );
        personDTO.firstName( person.getFirstName() );
        personDTO.id( person.getId() );
        personDTO.lastName( person.getLastName() );
        List<Phone> list = person.getPhones();
        if ( list != null ) {
            personDTO.phones( new ArrayList<Phone>( list ) );
        }

        return personDTO.build();
    }
}
