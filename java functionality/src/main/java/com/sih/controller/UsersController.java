package com.sih.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sih.model.LoanScheme;
import com.sih.services.LoanSchemeService;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private LoanSchemeService loanSchemeService;
	
	@GetMapping("/home")
	public String usersHome(){
		return "users/users-home";
	}
	
	@GetMapping("/schemes")
	public String allSchemes(Model model){
		List<LoanScheme> loanSchemes = loanSchemeService.getLoanSchemes();
		
		model.addAttribute("schemes",loanSchemes);
		
		return "users/schemes";
	}
	
	@GetMapping("/registerForm")
	public String shoeRegisterForm(@RequestParam("loanScheme") String loanSchemeId){
		
		return "users/loan-registration";
	}
	
}
