package com.alhussain.demo.service;

import com.alhussain.demo.dto.PersonDTO;
import com.alhussain.demo.repository.PersonRepository;
import lombok.AllArgsConstructor;
import com.alhussain.demo.model.Person;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BasicService {

	private PersonRepository repository;
	private ModelMapper mapper;

	public PersonDTO fetchPerson(Long id) {
		Optional<Person> person = repository.findById(id);

		if (!person.isPresent())
			throw new IllegalArgumentException("user with this id is not present");

		return mapper.map(person.get(), PersonDTO.class);
	}

	@Transactional
	public PersonDTO createPerson(PersonDTO personDTO) {
		repository.save(mapper.map(personDTO, Person.class));
		return personDTO;
	}
}
