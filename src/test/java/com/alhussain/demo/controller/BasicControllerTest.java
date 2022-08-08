package com.alhussain.demo.controller;

import com.alhussain.demo.model.Person;
import com.alhussain.demo.repository.PersonRepository;
import com.alhussain.demo.service.BasicService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class BasicControllerTest {

    @Mock
    BasicService pesronService;

    @Mock
    PersonRepository personRepository;

    @Autowired
    MockMvc mockMvc;


    @Test
    public void shouldDeletePerson() throws Exception {
        Person person = new Person();
        person.setId(5L);
        person.setName("Mohamed");
        when(personRepository.findById(any())).thenReturn(Optional.of(person));
        mockMvc.perform(delete(
                        "/demo/person/{id}", 5L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(personRepository).findById(any());
        verify(personRepository).delete(person);



    }

}