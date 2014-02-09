package com.cenfotec.springdata.pojo;

public class TeamPOJO {

	private int teamId;
	private String name;
	private String stadium;
	private String coach;
		
	public TeamPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int pTeamId) {
		this.teamId = pTeamId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String pName) {
		this.name = pName;
	}
	
	public String getStadium() {
		return stadium;
	}

	public void setStadium(String pStadium) {
		this.stadium = pStadium;
	}
	
	public String getCoach() {
		return coach;
	}

	public void setCoach(String pCoach) {
		this.coach = pCoach;
	}
}
