package com.lbg.ProjectAnna.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.lbg.ProjectAnna.domain.Situation;
import com.lbg.ProjectAnna.repo.SituationRepo;

@Service
public class SituationService {
	
	private SituationRepo repo;
	
	

	public SituationService(SituationRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Situation> createSituation(Situation newSituation) {
		Situation created = this.repo.save(newSituation);
		return new ResponseEntity<Situation>(created, HttpStatus.CREATED);
	}

	public List<Situation> getSituations() {
		return this.repo.findAll();
	}

	public boolean deleteSituation(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
		
	}
	
	


}
