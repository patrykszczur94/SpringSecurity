package com.springseciurity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleController {

	// main page controller
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String welcomePage(ModelMap model) {
		
		model.addAttribute("user",getUserData());
		return"mainPage";
	}
	
	// admin hello page controller
	@RequestMapping(value="/admin" , method= RequestMethod.GET)
	public String adminPage(ModelMap model) { 
		
		model.addAttribute("user",getUserData());
		return"admin";
	}
	
	// login page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		
	    return "login";
	}
	 
	// function responsible for logout user  
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication != null){    
	        new SecurityContextLogoutHandler().logout(request, response, authentication);
	    }
	    return "redirect:/login?logout";
	}
	
	// access denied page
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		  
		model.addAttribute("user", getUserData());
		return "denied";
	  }
	  
	// this is standard spring function to receive user data
	private String getUserData() {  
		  
		String userName;
		Object principial = SecurityContextHolder.getContext().getAuthentication().getPrincipal();	
		if(principial instanceof UserDetails) {
			userName = ((UserDetails) principial).getUsername();
		} else {
			userName = principial.toString(); 
		}
		return userName;  
	}
	  
}
