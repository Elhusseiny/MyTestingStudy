package com.alhussain.demo.service;

import com.alhussain.demo.model.Person;
import com.alhussain.demo.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
class BasicServiceTest {

    @Mock
    PersonRepository repository;

    // @InjectMocks //creates an instance not a mock
    @Mock
    BasicService service ;

    Person person ;

    @BeforeEach
    public void setup()
    {
         person = new Person();
         person.setName("test");
    }
    @Test
    public void shouldInsertInDatabase()
    {
        when(service.showMessage()).thenReturn("test message") ;
        log.info(service.showMessage());
        repository.save(person);
        verify(repository).save(person);
        //verify(repository).findAll(); //will fail

    }
}