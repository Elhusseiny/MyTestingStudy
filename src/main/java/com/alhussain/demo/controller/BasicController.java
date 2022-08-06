package com.alhussain.demo.controller;

import com.alhussain.demo.dto.PersonDTO;
import com.alhussain.demo.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class BasicController {

	@Autowired
	BasicService basicService;

	@GetMapping("/basic")
	public Integer getBasicMessage() {
		return basicService.basicServiceTest();
	}

	@GetMapping("/basic_1")
	public Integer getBasicMessage1() {
		if (7 > 5)
			throw new NullPointerException();
		return null;
	}

	@GetMapping("/basic_2/{name}")
	public PersonDTO getBasicMessage2(@PathVariable ("name") String name) {
		return new PersonDTO().setId(0L).setName(name); // dummy behaviour
	}
}
