package com.alhussain.demo.service;


import com.alhussain.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnotherService {

    private PersonRepository repository;

    public String showMeAnotherMessage()
    {
        return "real message" ;
    }
}
