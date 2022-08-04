package com.alhussain.demo.controller;

import com.alhussain.demo.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
