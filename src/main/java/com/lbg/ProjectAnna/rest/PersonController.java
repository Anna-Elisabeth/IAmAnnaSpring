package com.lbg.ProjectAnna.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.ProjectAnna.domain.Challenge;
import com.lbg.ProjectAnna.domain.Person;

import com.lbg.ProjectAnna.service.PersonService;


@RestController
@RequestMapping("/person")
@CrossOrigin
public class PersonController {

	private PersonService service;

	public PersonController(PersonService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Person> createPerson(@RequestBody Person newPerson) {
		return this.service.createPerson(newPerson);
	}
	
	@GetMapping("/get")
	public List<Person> getPeople() {
		return this.service.getPeople();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable int id) {
		return this.service.getPersonById(id);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deletePerson(@PathVariable int id) {
		return this.service.deletePerson(id);

	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person updatePerson) {

		return this.service.updatePerson(id, updatePerson);

	}
	

}
