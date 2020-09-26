package com.shree.batch.services.person;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.shree.batch.dao.entity.PersonEntity;
import com.shree.batch.model.Person;
import com.shree.batch.repository.PersonRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class PersonServiceImplTest {

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonService personService;

    Mapper mapper;

    @BeforeEach
    void setUp() {
        mapper = DozerBeanMapperBuilder.buildDefault();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void listPerson() {
    }

    @Test
    void getPerson() {
        PersonEntity personEntity = personRepository.getOne(1l);
    }

    @Test
    void savePersonBulk() {
    }

    void savePerson() {
//        Person person = Person.builder()
//                .firstName("Jurgen")
//                .lastName("Klopp")
//                .build();
        Person person = new Person();
        person.setFirstName("Jurgen");
        person.setLastName("Klopp");
        when(personRepository.save(any(PersonEntity.class))).thenReturn(new PersonEntity());
        Person personPersisted = personService.savePerson(person);
        assertThat(person.getFirstName()).isSameAs(personPersisted.getFirstName());
    }
}