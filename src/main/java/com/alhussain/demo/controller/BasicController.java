package com.alhussain.demo.controller;

import com.alhussain.demo.dto.PersonDTO;
import com.alhussain.demo.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class BasicController {

	@Autowired
	BasicService basicService;

	@GetMapping("/person/{id}")
	public PersonDTO getBasicMessage(@PathVariable("id") Long id) {
		return basicService.fetchPerson(id);
	}

	@PostMapping("/person")
	public PersonDTO createPerson( @RequestBody PersonDTO person) {
		return basicService.createPerson(person) ;

	}
}
