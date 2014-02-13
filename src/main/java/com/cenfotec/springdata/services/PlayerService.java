package com.cenfotec.springdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.cenfotec.springdata.contracts.PlayerRequest;
import com.cenfotec.springdata.ejb.Player;
import com.cenfotec.springdata.repositories.PlayerRepository;

@Service
public class PlayerService implements IPlayerService{

	@Autowired
	PlayerRepository playerRepository;
	
		
	@Override
	public Page<Player> getAllPlayers(PlayerRequest ur){
		
		PageRequest pr;
		Sort.Direction direction = Sort.Direction.DESC;
		if(ur.getDirection().equals("ASC")){
			direction = Sort.Direction.ASC;
		}
		
		if(ur.getSortBy().size() > 0){
			Sort sort = new Sort(direction,ur.getSortBy());
			pr = new PageRequest(ur.getPageNumber(), ur.getPageSize(),sort);
		} else {
			pr = new PageRequest(ur.getPageNumber(), ur.getPageSize());
		}
		
		Page<Player> result;
		if(ur.getSearchColumn().toLowerCase().equals("all")){
			result = playerRepository.findAll(pr);
		}else if(ur.getSearchColumn().toLowerCase().equals("firstname")){
			result = playerRepository.findByFirstnameContaining(ur.getSearchTerm(),pr);
		} else if(ur.getSearchColumn().toLowerCase().equals("lastname")){
			result = playerRepository.findByLastnameContaining(ur.getSearchTerm(),pr);
		} else if(ur.getSearchColumn().toLowerCase().equals("dorsal")){
			result = playerRepository.findByDorsalContaining(ur.getSearchTerm(),pr);
		} else {
			result = playerRepository.findAll(pr);
		}
		return result;		
	}
	
	@Override
	public Boolean savePlayer(Player player){
		Player playerAdded = playerRepository.save(player);
		
		if(playerAdded == null){
			return false;
		}
		
		return true;
	}
}
