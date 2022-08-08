package com.alhussain.demo.service;

import com.alhussain.demo.dto.PersonDTO;
import com.alhussain.demo.repository.PersonRepository;
import lombok.AllArgsConstructor;
import com.alhussain.demo.model.Person;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
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
	public Long deletePerson(Long id)
	{
		Person person = repository.findById(id).get();
		repository.delete(person);
		return id ;
	}

	public String showMessage()
	{
		return "actual message" ;
	}

	@Transactional
	public PersonDTO createPerson(PersonDTO personDTO) {
		repository.save(mapper.map(personDTO, Person.class));
		return personDTO;
	}
}
