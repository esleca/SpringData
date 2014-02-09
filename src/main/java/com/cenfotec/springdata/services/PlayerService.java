package com.cenfotec.springdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.springdata.ejb.Player;
import com.cenfotec.springdata.repositories.PlayerRepository;

@Service
public class PlayerService implements IPlayerService{

	@Autowired
	PlayerRepository playerRepository;
	
	@Override
	public Player getPlayerByFirstname(String firstname){
		return playerRepository.findByFirstname(firstname);
	}
	
	@Override
	public Player getPlayerByLastname(String lastname){
		return playerRepository.findByLastname(lastname);
	}
	
	@Override
	public List<Player> getAllPlayers(){
		return (List<Player>) playerRepository.findAll();
	}
}
