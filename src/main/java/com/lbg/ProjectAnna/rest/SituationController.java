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

import com.lbg.ProjectAnna.domain.Person;
import com.lbg.ProjectAnna.domain.Situation;
import com.lbg.ProjectAnna.service.SituationService;

@RestController
@RequestMapping("/situation")
@CrossOrigin
public class SituationController {
	
	private SituationService service;

	public SituationController(SituationService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Situation> createSituation(@RequestBody Situation newSituation) {
		return this.service.createSituation(newSituation);
	}

	@GetMapping("/get")
	public List<Situation> getSituations() {
		return this.service.getSituations();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Situation> getSituationById(@PathVariable int id) {
		return this.service.getSituationById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteSituation(@PathVariable int id) {
		return this.service.deleteSituation(id);
		

	}
	
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<Situation> updateSituation(@PathVariable int id, @RequestBody Situation updatedSituation) {

		return this.service.updateSituation(id, updatedSituation);

	}

}
