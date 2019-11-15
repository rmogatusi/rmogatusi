package com.mogatusi.online.registration.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mogatusi.online.registration.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	List<Person>findAll();
}