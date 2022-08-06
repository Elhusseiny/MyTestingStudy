package com.alhussain.demo.service;

import org.springframework.stereotype.Service;

@Service
public class BasicService {

	private Integer age = 10;

	public Integer basicServiceTest()
	{
		return 200 ;
	}

	public Integer basicServiceTest2()
	{
		return this.age ;
	}
}
