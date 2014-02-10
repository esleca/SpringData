package com.cenfotec.springdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cenfotec.springdata.contracts.TeamRequest;
import com.cenfotec.springdata.ejb.Team;
import com.cenfotec.springdata.repositories.TeamRepository;

@Service
public class TeamService implements ITeamService {

	@Autowired
	TeamRepository teamRepository;
	
	@Override
	public Team getTeamById(int id){
		return teamRepository.findOne(id);
	}
	
	@Override
	public Team getTeamByName(String name){
		return teamRepository.findByName(name);
	}
	
	@Override
	public Page<Team> getAllTeams(TeamRequest ur){
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
		
		return teamRepository.findAll(pr);
	}
	
	@Override
	public Boolean saveTeam(Team team){
		Team teamAdded = teamRepository.save(team);
		
		if(teamAdded == null){
			return false;
		}
		
		return true;
	}
}
