package com.cenfotec.springdata.contracts;

import java.util.List;
import com.cenfotec.springdata.pojo.PlayerPOJO;

public class PlayerResponse extends BaseResponse {

	private List<PlayerPOJO> players;
	
	public PlayerResponse(){
		super();
	}
	
	public List<PlayerPOJO> getPlayers(){
		return players;
	}
	
	public void setPlayers(List<PlayerPOJO> pPlayers){
		this.players = pPlayers;
	}
	
}
