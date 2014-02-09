package com.cenfotec.springdata.pojo;

public class PlayerPOJO{
	
	private int playerId;
	private Integer teamId;
	private String firstname;
	private String lastname;
	private int dorsal;
		
	public PlayerPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int pPlayerId) {
		this.playerId = pPlayerId;
	}
	
	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer pTeamId) {
		this.teamId = pTeamId;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int pDorsal) {
		this.dorsal = pDorsal;
	}

}
