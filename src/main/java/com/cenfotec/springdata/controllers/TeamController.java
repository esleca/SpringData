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

import com.cenfotec.springdata.contracts.TeamRequest;
import com.cenfotec.springdata.contracts.TeamResponse;
import com.cenfotec.springdata.ejb.Team;
import com.cenfotec.springdata.pojo.TeamPOJO;
import com.cenfotec.springdata.services.ITeamService;
import com.cenfotec.springdata.utils.PojoUtils;

@Component
@Path("/protected/team")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class TeamController {

	@Autowired
	ITeamService teamService;

	@Path("/getAllTeams")
	@POST
	@Transactional
	public TeamResponse getAllTeams(TeamRequest pr){
		pr.setPageNumber(pr.getPageNumber() - 1);
		Page<Team> teams = teamService.getAllTeams(pr);
		
		TeamResponse teamResponse = new TeamResponse();
		
		teamResponse.setCode(200);
		teamResponse.setCodeMessage("Team fetch correctly");
		teamResponse.setTotalElements(teams.getTotalElements());
		teamResponse.setTotalPages(teams.getTotalPages());
		
		List<TeamPOJO> viewTeams = new ArrayList<TeamPOJO>();
		for (Team team : teams.getContent()){
			TeamPOJO mapPlayer = new TeamPOJO();
			PojoUtils.pojoMappingUtility(mapPlayer, team);
			viewTeams.add(mapPlayer);
		}
		
		teamResponse.setTeams(viewTeams);
		System.out.println("Teams quantity: " + teamResponse.getTeams().size());
		return teamResponse;		
	}
	
	
	@Path("/createTeam")
	@POST
	public TeamResponse createTeam(TeamRequest pr){
		
		TeamResponse teamResponse = new TeamResponse();
		
		Team team = new Team();
		team.setName(pr.getTeam().getName());
		team.setStadium(pr.getTeam().getStadium());
		team.setCoach(pr.getTeam().getCoach());
		team.setName(pr.getTeam().getName());
		
		Boolean state = teamService.saveTeam(team);
		
		if(state){
			teamResponse.setCode(200);
			teamResponse.setCodeMessage("team created successfully");
		}		
		return teamResponse;
	}
	
	
}
