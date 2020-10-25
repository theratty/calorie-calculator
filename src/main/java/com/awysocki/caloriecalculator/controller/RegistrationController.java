package com.awysocki.caloriecalculator.controller;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import com.awysocki.caloriecalculator.entity.Role;
import com.awysocki.caloriecalculator.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awysocki.caloriecalculator.user.CrmUser;
import com.awysocki.caloriecalculator.entity.User;
import com.awysocki.caloriecalculator.service.UserService;

/**
 * This controller handles registration operations.
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {
	
    @Autowired
    private UserService userService;

    @Autowired
	private RoleService roleService;
	
    private Logger logger = Logger.getLogger(getClass().getName());

	private Map<String, String> roles;

	@PostConstruct
	protected void loadRoles() {
		roles = new LinkedHashMap<String, String>();
		roles.put("ROLE_STANDARD", "Standard");
	}
    
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	@GetMapping("/showRegistrationForm")
	public String showMyLoginPage(Model theModel) {
		
		theModel.addAttribute("crmUser", new CrmUser());
		theModel.addAttribute("roles", roles);
		
		return "registration-form";
	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(
				@Valid @ModelAttribute("crmUser") CrmUser theCrmUser, 
				BindingResult theBindingResult, 
				Model theModel) {
		
		String userName = theCrmUser.getUserName();
		logger.info("Processing registration form for: " + userName);

		 if (theBindingResult.hasErrors()){
			 return "registration-form";
	        }

        User existing = userService.findByUserName(userName);
        if (existing != null){
        	theModel.addAttribute("crmUser", new CrmUser());
			theModel.addAttribute("registrationError", "User name already exists.");
			theModel.addAttribute("roles", roles);

			logger.warning("User name already exists.");
        	return "registration-form";
        }

		List<Role> userRoles = new LinkedList<>();
        userRoles.add(roleService.findByName(theCrmUser.getFormRole()));

        userService.save(theCrmUser, userRoles);
        
        logger.info("Successfully created user: " + userName);
        
        return "registration-confirmation";		
	}
}
