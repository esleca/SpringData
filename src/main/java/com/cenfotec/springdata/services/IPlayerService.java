package com.cenfotec.springdata.services;

import java.util.List;

import com.cenfotec.springdata.ejb.Player;

public interface IPlayerService {

	Player getPlayerByFirstname(String firstname);
	Player getPlayerByLastname(String lastname);
	List<Player> getAllPlayers();
	
}
