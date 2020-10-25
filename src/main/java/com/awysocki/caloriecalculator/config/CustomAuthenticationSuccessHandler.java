package com.awysocki.caloriecalculator.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.awysocki.caloriecalculator.entity.User;
import com.awysocki.caloriecalculator.service.UserService;

/**
 * This class is used to prepare session environment when user successfully logged in
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;


	/**
	 * This method prepares session data about currently logged in user
	 * @param request
	 * @param response
	 * @param authentication
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
										HttpServletResponse response,
										Authentication authentication)
			throws IOException, ServletException {


		String userName = authentication.getName();
		System.out.println("User logged in - username: " + userName);
		User theUser = userService.findByUserName(userName);

		HttpSession session = request.getSession();
		session.setAttribute("user", theUser);

		
		response.sendRedirect(request.getContextPath() + "/");
	}

}
