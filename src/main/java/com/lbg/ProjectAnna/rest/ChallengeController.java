package com.lbg.ProjectAnna.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.ProjectAnna.domain.Challenge;
import com.lbg.ProjectAnna.domain.Person;
import com.lbg.ProjectAnna.service.ChallengeService;

@RestController
@RequestMapping("/challenge")
@CrossOrigin
public class ChallengeController {
	
	private ChallengeService service;

	public ChallengeController(ChallengeService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Challenge> createChallenge(@RequestBody Challenge newChallenge) {
		return this.service.createChallenge(newChallenge);
	}
	
	@GetMapping("/get")
	public List<Challenge> getChallenges() {
		return this.service.getChallenges();
	}

}
