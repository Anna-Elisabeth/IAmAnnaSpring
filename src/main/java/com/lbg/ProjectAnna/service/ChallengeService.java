package com.lbg.ProjectAnna.service;

import java.util.List;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.ProjectAnna.domain.Challenge;

import com.lbg.ProjectAnna.repo.ChallengeRepo;

@Service
public class ChallengeService {
	
	private ChallengeRepo repo;
	
	
	
	public ChallengeService(ChallengeRepo repo) {
		super();
		this.repo = repo;
	}

	


	public ResponseEntity<Challenge> createChallenge(Challenge newChallenge) {
		Challenge created = this.repo.save(newChallenge);
		return new ResponseEntity<Challenge>(created, HttpStatus.CREATED);
	}
	
	public List<Challenge> getChallenges() {
		return this.repo.findAll();
	}



	public ResponseEntity<Challenge> getChallengeById(int id) {
	
	
		Optional<Challenge> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Challenge>(HttpStatus.NOT_FOUND);
		}

		Challenge body = found.get();

		return ResponseEntity.ok(body);

	}




	public boolean deleteChallenge(int id) {
	
		this.repo.deleteById(id);
		return !this.repo.existsById(id);

	}




	public ResponseEntity<Challenge> updateChallenge(int id, Challenge updateChallenge) {

	    Optional<Challenge> found = this.repo.findById(id);

	    if (found.isEmpty()) {
	        return new ResponseEntity<Challenge>(HttpStatus.NOT_FOUND);
	    }

	    Challenge existing = found.get();

	    
	    if (updateChallenge.getStory() != null) {
	        existing.setStory(updateChallenge.getStory());
	    }

	    Challenge updated = this.repo.save(existing);

	    return ResponseEntity.ok(updated);
	}
	
	
	
	
	
	

}
