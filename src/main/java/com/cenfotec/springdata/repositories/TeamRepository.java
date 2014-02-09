package com.cenfotec.springdata.repositories;

import org.springframework.data.repository.CrudRepository;
import com.cenfotec.springdata.ejb.Team;

public interface TeamRepository extends CrudRepository<Team, Integer>{

	Team findByName(String pName);
	
}
