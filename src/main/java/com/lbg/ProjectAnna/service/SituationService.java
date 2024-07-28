package com.lbg.ProjectAnna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.ProjectAnna.domain.Person;
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

	public ResponseEntity<Situation> getSituationById(int id) {
	Optional<Situation> found = this.repo.findById(id);
		
		if (found.isEmpty()) {
			return new ResponseEntity<Situation>(HttpStatus.NOT_FOUND);
		}

		Situation body = found.get();

		return ResponseEntity.ok(body);

	}
	
	
	

	public ResponseEntity<Situation> updateSituation(int id, Situation updatedSituation) {
		 
		Optional<Situation> found = this.repo.findById(id);

		    if (found.isEmpty()) {
		        return new ResponseEntity<Situation>(HttpStatus.NOT_FOUND);
		    }

		    Situation existing = found.get();

		    
		    if (updatedSituation.getScenario() != null) {
		        existing.setScenario(updatedSituation.getScenario());
		    }

		    Situation updated = this.repo.save(existing);

		    return ResponseEntity.ok(updated);
		}


}
