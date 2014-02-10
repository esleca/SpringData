package com.cenfotec.springdata.services;

import com.cenfotec.springdata.contracts.TeamRequest;
import com.cenfotec.springdata.ejb.Team;
import org.springframework.data.domain.Page;

public interface ITeamService {

	Team getTeamById(int id);
	Team getTeamByName(String name);
	Page<Team> getAllTeams(TeamRequest tr);		
	
	Boolean saveTeam(Team team);
}
