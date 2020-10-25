package com.awysocki.caloriecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * This is main page controller. It only return application's home page.
 */
@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping("/")
	public String showHome() {

		return "home";
	}
	
}










