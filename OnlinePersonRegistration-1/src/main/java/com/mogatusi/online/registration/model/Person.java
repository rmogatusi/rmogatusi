package com.mogatusi.online.registration.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	private Long idNumber;	
	
	private String name;
	private String surname;
		
	private Person() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public long getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(Long idNumber) {
		this.idNumber = idNumber;
	}
}
