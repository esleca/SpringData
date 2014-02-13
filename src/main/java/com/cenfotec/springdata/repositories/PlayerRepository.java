package com.cenfotec.springdata.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.cenfotec.springdata.ejb.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer>{
	
	Page<Player> findByFirstnameContaining(String pFirstName, Pageable pageable);
	Page<Player> findByLastnameContaining(String pLastName, Pageable pageable);
	Page<Player> findByDorsalContaining(String pDorsal, Pageable pageable);
	Page<Player> findAll(Pageable pageable);
}
