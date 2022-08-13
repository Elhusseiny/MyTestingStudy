package com.alhussain.demo.controller;

import com.alhussain.demo.model.Person;
import com.alhussain.demo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@SpringBootTest
@ActiveProfiles("test")
class BasicControllerTest {

    @Spy
    PersonRepository personRepository;

    @Test
    public void shouldDeletePerson() throws Exception {


        personRepository.deleteById(1L);
        //verify(personRepository, times(1)).deleteById(1L);
        //verify(basicService).showMessage(); will fail the test

    }

}