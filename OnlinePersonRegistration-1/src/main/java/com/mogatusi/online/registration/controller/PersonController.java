package com.mogatusi.online.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mogatusi.online.registration.model.Person;
import com.mogatusi.online.registration.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping("/savePerson")
	public String savePerson(@RequestBody Person person) {

		if (!validatePerson(person)) {
			return "Request to save person failed. Please check that the person's details are valid, then try again.";
		}
		personService.savePerson(person);
		return "Person saved.";
	}
	
	@GetMapping("/getAllPeople")
	public List<Person> getAllPeople(){
		return personService.getAllPeople();
	}
	
	private boolean validatePerson(Person person) {
		if (!person.equals(null)) {
			if (!person.getName().isEmpty() && !person.getSurname().isEmpty() && (Long.valueOf(person.getIdNumber()) != null)){
				return true;
			}
		}
		return false;
	}
	
}