package com.cenfotec.springdata.contracts;

import com.cenfotec.springdata.pojo.PlayerPOJO;

public class PlayerRequest extends BasePagingRequest {

	private PlayerPOJO player;
	
	public PlayerRequest(){
		super();
	}
	
	public PlayerPOJO getPlayer(){
		return player;
	}
	
	public void setPlayer(PlayerPOJO pPlayer){
		this.player = pPlayer;
	}
	
}
