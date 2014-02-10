package com.cenfotec.springdata.services;

import org.springframework.data.domain.Page;

import com.cenfotec.springdata.contracts.PlayerRequest;
import com.cenfotec.springdata.ejb.Player;

public interface IPlayerService {

	Player getPlayerByFirstname(String firstname);
	Player getPlayerByLastname(String lastname);
	Page<Player> getAllPlayers(PlayerRequest pr);
	
	Boolean savePlayer(Player player);
	
}
