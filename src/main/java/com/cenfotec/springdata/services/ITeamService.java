package com.cenfotec.springdata.services;

import java.util.List;
import com.cenfotec.springdata.ejb.Team;

public interface ITeamService {

	Team getTeamByName(String name);
	List<Team> getAllTeams();		
}
