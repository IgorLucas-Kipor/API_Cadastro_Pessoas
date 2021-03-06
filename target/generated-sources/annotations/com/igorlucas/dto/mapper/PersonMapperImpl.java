package com.igorlucas.dto.mapper;

import com.igorlucas.dto.request.PersonDTO;
import com.igorlucas.dto.request.PersonDTO.PersonDTOBuilder;
import com.igorlucas.dto.request.PhoneDTO;
import com.igorlucas.dto.request.PhoneDTO.PhoneDTOBuilder;
import com.igorlucas.entities.Person;
import com.igorlucas.entities.Person.PersonBuilder;
import com.igorlucas.entities.Phone;
import com.igorlucas.entities.Phone.PhoneBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-18T22:31:22-0300",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
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
        person.phones( phoneDTOListToPhoneList( personDTO.getPhones() ) );

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
        personDTO.phones( phoneListToPhoneDTOList( person.getPhones() ) );

        return personDTO.build();
    }

    protected Phone phoneDTOToPhone(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        PhoneBuilder phone = Phone.builder();

        phone.id( phoneDTO.getId() );
        phone.number( phoneDTO.getNumber() );
        phone.type( phoneDTO.getType() );

        return phone.build();
    }

    protected List<Phone> phoneDTOListToPhoneList(List<PhoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Phone> list1 = new ArrayList<Phone>( list.size() );
        for ( PhoneDTO phoneDTO : list ) {
            list1.add( phoneDTOToPhone( phoneDTO ) );
        }

        return list1;
    }

    protected PhoneDTO phoneToPhoneDTO(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDTOBuilder phoneDTO = PhoneDTO.builder();

        phoneDTO.id( phone.getId() );
        phoneDTO.number( phone.getNumber() );
        phoneDTO.type( phone.getType() );

        return phoneDTO.build();
    }

    protected List<PhoneDTO> phoneListToPhoneDTOList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDTO> list1 = new ArrayList<PhoneDTO>( list.size() );
        for ( Phone phone : list ) {
            list1.add( phoneToPhoneDTO( phone ) );
        }

        return list1;
    }
}
