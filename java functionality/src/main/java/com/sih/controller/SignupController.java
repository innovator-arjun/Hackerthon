package com.sih.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sih.model.User;

@Controller
public class SignupController {
	
	@Autowired
	private UserDetailsManager userDetailsManager;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@GetMapping("/signup")
	public String showSignUp(Model model){
		model.addAttribute("user",new User());
		return "signup";
	}
	
	@PostMapping("signupProcess")
	public String processSignUpForm(@Valid @ModelAttribute("user") User user,BindingResult bindingResult,Model model){
		String username = user.getUsername();
		String password = user.getPassword();
		String repeatPassword = user.getRepeatPassword();
		//Form Validation
		if(bindingResult.hasErrors()){
			model.addAttribute("user",new User());
			model.addAttribute("signupError","Username/Password cannot be Empty");
			
			return "signup";
		}
		
		//check passwords match
		if(!doesPasswordsMatch(password, repeatPassword)){
			model.addAttribute("user",new User());
			model.addAttribute("passwordMismatch","Passwords not match");
			return "signup";
		}
		// check the database if user already exists 
		if(doesUserExist(username)){
			model.addAttribute("user",new User());
			model.addAttribute("userExists","Username Already Exists");
			return "signup";
		}
		// encrypt the password
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		// prepend the encoding algorithm id
		encodedPassword = "{bcrypt}"+encodedPassword;
		// give user default role of "employee"
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
		// create user details object 
		org.springframework.security.core.userdetails.User tempUser = new org.springframework.security.core.userdetails.User(username,encodedPassword,authorities);
		// save user in the database 
		userDetailsManager.createUser(tempUser);
		model.addAttribute("signupSuccess","User successfully Created");
		return "home";
	}
	
	private boolean doesUserExist(String username){
		boolean exists = userDetailsManager.userExists(username);
		return exists;
	}
	
	private boolean doesPasswordsMatch(String password,String repeatPassword){
		boolean matches = false;
		if(password.equals(repeatPassword)){
			matches=true;
		}
		return matches;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
