package com.lbg.ProjectAnna.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.ProjectAnna.domain.Person;


public interface PersonRepo  extends JpaRepository<Person, Integer>{

	
}
