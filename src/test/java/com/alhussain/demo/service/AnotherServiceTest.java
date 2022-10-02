package com.alhussain.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.alhussain.demo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class AnotherServiceTest {
    @Mock
    private PersonRepository personRepository ;

    @Mock
    private AnotherService anotherService ;

    @InjectMocks
    private AnotherService anotherService2 ;

    @Test
    void testShowMeAnotherMessage() {

        //read this: https://stackoverflow.com/questions/16467685/difference-between-mock-and-injectmocks
        // this will give null value because the service is mocked but methods not so will return null.
        assertEquals(null, anotherService.showMeAnotherMessage());
        when(anotherService.showMeAnotherMessage()).thenReturn("test message");
        assertEquals("test message", anotherService.showMeAnotherMessage());
        assertEquals("real message", anotherService2.showMeAnotherMessage());
    }
}

