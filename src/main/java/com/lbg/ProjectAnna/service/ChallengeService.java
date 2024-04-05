package com.lbg.ProjectAnna.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.ProjectAnna.domain.Challenge;
import com.lbg.ProjectAnna.domain.Setting;
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

}
