package com.mogatusi.online.registration.service;

import java.util.List;

import com.mogatusi.online.registration.model.Person;

public interface PersonService {

	void savePerson(Person person);
	
	List<Person> getAllPeople();
}
