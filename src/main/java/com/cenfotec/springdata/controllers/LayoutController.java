package com.cenfotec.springdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/layoutservice")
public class LayoutController {			
	
	@RequestMapping(value = "/playerslayout")
	public String getPlayersLayout()
	{
		return "home";
	}
	
	@RequestMapping(value = "/player/createPlayerModal")
	public String getCreatePlayerModal()
	{
		return "modals/createPlayerModal";
	}
}
