package com.cenfotec.springdata.contracts;

import java.util.List;

import com.cenfotec.springdata.pojo.TeamPOJO;

public class TeamResponse extends BaseResponse {

private List<TeamPOJO> teams;
	
	public TeamResponse(){
		super();
	}
	
	public List<TeamPOJO> getTeams(){
		return teams;
	}
	
	public void setTeams(List<TeamPOJO> pTeams){
		this.teams = pTeams;
	}
	
}
