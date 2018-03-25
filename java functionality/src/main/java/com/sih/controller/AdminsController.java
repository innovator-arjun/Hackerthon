package com.sih.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admins")
public class AdminsController {

	@GetMapping("/home")
	public String adminsHome(){
		return "admins/admins-home";
	}
	
	@GetMapping("/meeting")
	public String adminsMeeting(){
		return "admins/meeting";
	}
}
