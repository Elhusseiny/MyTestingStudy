package com.alhussain.demo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PersonDTO {
	private Long id;
	private String name;
}
