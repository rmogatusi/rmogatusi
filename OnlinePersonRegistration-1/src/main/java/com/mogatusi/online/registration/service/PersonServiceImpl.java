package com.mogatusi.online.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogatusi.online.registration.model.Person;
import com.mogatusi.online.registration.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	private final PersonRepository repository;
	
	@Autowired
	public PersonServiceImpl(PersonRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void savePerson(Person person) {
		repository.save(person);
	}

	@Override
	public List<Person> getAllPeople() {
		return repository.findAll();
	}
}
