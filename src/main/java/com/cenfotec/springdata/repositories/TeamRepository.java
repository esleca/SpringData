package com.cenfotec.springdata.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.cenfotec.springdata.ejb.Team;

public interface TeamRepository extends CrudRepository<Team, Integer>{
	
	Team findByName(String pName);
	Page<Team> findAll(Pageable pageable);
}
