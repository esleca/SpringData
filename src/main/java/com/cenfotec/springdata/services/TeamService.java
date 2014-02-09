package com.cenfotec.springdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.springdata.ejb.Team;
import com.cenfotec.springdata.repositories.TeamRepository;

@Service
public class TeamService implements ITeamService {

	@Autowired
	TeamRepository teamRepository;
	
	@Override
	public Team getTeamByName(String name){
		return teamRepository.findByName(name);
	}
	
	@Override
	public List<Team> getAllTeams(){
		return (List<Team>) teamRepository.findAll();
	}
}
