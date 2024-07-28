package com.lbg.ProjectAnna.service;


import java.util.List;
import java.util.Optional;

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


	public ResponseEntity<Person> getPersonById(int id) {
		Optional<Person> found = this.repo.findById(id);
		
		if (found.isEmpty()) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}

		Person body = found.get();

		return ResponseEntity.ok(body);

	}
	
	public boolean deletePerson(int id) {
		
		this.repo.deleteById(id);
		return !this.repo.existsById(id);

	}


	public ResponseEntity<Person> updatePerson(int id, Person updatePerson) {
		
		 Optional<Person> found = this.repo.findById(id);

		    if (found.isEmpty()) {
		        return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		    }

		    Person existing = found.get();

		    
		    if (updatePerson.getCharacterName() != null) {
		        existing.setCharacterName(updatePerson.getCharacterName());
		    }

		    Person updated = this.repo.save(existing);

		    return ResponseEntity.ok(updated);
		}

	

}
