package com.cenfotec.springdata.contracts;

import com.cenfotec.springdata.pojo.TeamPOJO;

public class TeamRequest extends BasePagingRequest {

	private TeamPOJO team;
	
	public TeamRequest(){
		super();
	}
	
	public TeamPOJO getTeam(){
		return team;
	}
	
	public void setTeam(TeamPOJO pTeam){
		this.team = pTeam;
	}
	
	
}
