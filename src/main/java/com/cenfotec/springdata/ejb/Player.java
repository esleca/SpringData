package com.cenfotec.springdata.ejb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Player implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int playerId;
	@Transient
	private Integer teamId;
	private String firstname;
	private String lastname;
	private int dorsal;
	
	//RELATIONSHIPS
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_teamId")
	private Team team;
			
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(int pPlayerId, String pFirstName, String pLastName, int pDorsal){
		super();		
		this.playerId = pPlayerId;
		this.firstname = pFirstName;
		this.lastname = pLastName;
		this.dorsal = pDorsal;		
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
