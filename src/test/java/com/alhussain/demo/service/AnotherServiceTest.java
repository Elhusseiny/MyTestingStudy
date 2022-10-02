package com.alhussain.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.alhussain.demo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class AnotherServiceTest {
    @Mock
    private PersonRepository personRepository ;

    @Mock
    private AnotherService anotherService ;

    @Test
    void testShowMeAnotherMessage() {

        //read this: https://stackoverflow.com/questions/16467685/difference-between-mock-and-injectmocks
        // this will give null pointer exception.
        assertEquals("another message", anotherService.showMeAnotherMessage());
    }
}

