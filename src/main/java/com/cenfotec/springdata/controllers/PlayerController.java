package com.cenfotec.springdata.controllers;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cenfotec.springdata.ejb.*;
import com.cenfotec.springdata.pojo.PlayerPOJO;
import com.cenfotec.springdata.services.IPlayerService;
import com.cenfotec.springdata.services.ITeamService;
import com.cenfotec.springdata.utils.PojoUtils;
import com.cenfotec.springdata.contracts.*;

@Component
@Path("/protected/player")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class PlayerController {
	
	@Autowired
	IPlayerService playerService;
	
	@Autowired
	ITeamService teamService;

	@Path("/getAllPlayers")
	@POST
	@Transactional
	public PlayerResponse getAllPlayers(PlayerRequest pr){
		pr.setPageNumber(pr.getPageNumber() - 1);
		Page<Player> players = playerService.getAllPlayers(pr);
		
		PlayerResponse playerResponse = new PlayerResponse();
		
		playerResponse.setCode(200);
		playerResponse.setCodeMessage("Players fetch correctly");
		playerResponse.setTotalElements(players.getTotalElements());
		playerResponse.setTotalPages(players.getTotalPages());
		
		List<PlayerPOJO> viewPlayers = new ArrayList<PlayerPOJO>();
		for (Player player : players.getContent()){
			PlayerPOJO mapPlayer = new PlayerPOJO();
			PojoUtils.pojoMappingUtility(mapPlayer, player);
			viewPlayers.add(mapPlayer);
		}
		
		playerResponse.setPlayers(viewPlayers);
		System.out.println("Players array size: " + playerResponse.getPlayers().size());
		return playerResponse;		
	}
	
	@Path("/createPlayer")
	@POST
	public PlayerResponse createPlayer(PlayerRequest pr){
		System.out.println("Iniciando creacion PLAYER");
		PlayerResponse playerResponse = new PlayerResponse();
		
		Team team = teamService.getTeamById(1/*pr.getPlayer().getTeamId()*/);
		
		Player player = new Player();
		player.setFirstname(pr.getPlayer().getFirstname());
		player.setLastname(pr.getPlayer().getLastname());
		player.setTeam(team);
		player.setDorsal(pr.getPlayer().getDorsal());
		
		Boolean state = playerService.savePlayer(player);
		
		if(state){
			playerResponse.setCode(200);
			playerResponse.setCodeMessage("player created successfully");
		}		
		System.out.println("fINALIZANDO creacion PLAYER");
		return playerResponse;
	}
	
	
	
}
