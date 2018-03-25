package com.sih.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/managers")
public class ManagersController {

	@GetMapping("/home")
	public String managersHome(){
		return "managers/managers-home";
	}
	
	@GetMapping("/meeting")
	public String managersMeeting(){
		return "managers/meeting";
	}
	
}
