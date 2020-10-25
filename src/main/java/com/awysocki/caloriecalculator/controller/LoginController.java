package com.awysocki.caloriecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * This controller is responsible for logging operations
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/showMyLoginPage")
	public String showMyLoginPage() {

		return "plain-login";
	}

	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}
	
}









