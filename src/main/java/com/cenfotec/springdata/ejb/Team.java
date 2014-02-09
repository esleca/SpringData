package com.cenfotec.springdata.ejb;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int teamId;
	private String name;
	private String stadium;
	private String coach;
		
	@OneToMany(cascade={CascadeType.ALL}, mappedBy="team")
	private List<Player> players;
		
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Team(int pTeamId, String pName, String pStadium, String pCoach, List<Player> pPlayers) {
		super();
		this.teamId = pTeamId;
		this.name = pName;
		this.stadium = pStadium;
		this.coach = pCoach;
		this.players = pPlayers;
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
	
	public List<Player> getTeamPlayers(){
		return players;
	}
	
	public void setTeamPlayers(List<Player> pPlayers){
		this.players = pPlayers;
	}
}
