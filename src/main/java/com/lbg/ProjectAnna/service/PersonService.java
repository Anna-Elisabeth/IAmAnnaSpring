package com.lbg.ProjectAnna.service;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.ProjectAnna.domain.Person;

import com.lbg.ProjectAnna.repo.PersonRepo;

import jakarta.transaction.Transactional;


@Service
public class PersonService {
	
	private PersonRepo repo;
	
	

	public PersonService(PersonRepo repo) {
		super();
		this.repo = repo;
	}

	 public ResponseEntity<Person> createPerson(Person newPerson) {
		    Person created = this.repo.save(newPerson);
		    return new ResponseEntity<Person>(created, HttpStatus.CREATED);
		}

	public List<Person> getPeople() {
		
		return this.repo.findAll();
	}

}
