package com.reimbursement.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.reimbursement.model.User;
import com.reimbursement.service.SystemService;

public class LoginController {
	/**
	 * 
	 */

	public SystemService ss;
	
	
	

	public LoginController(SystemService ss) {
		super();
		this.ss = ss;
	}

	public LoginController() {
		this(new SystemService());
	}



	public String login(HttpServletRequest req,HttpSession session) {
		String username = req.getAttribute("username").toString();
		String password = req.getAttribute("password").toString();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		User u;
		
		try{
			u = ss.getUser(username);
		}catch(Exception e) {
			return "index.html";
		}
		if(encoder.matches(password,u.getPassword())) {
			session.setAttribute("userId", u.getId());
			session.setAttribute("userRole", u.getRole().toString());
			return "login.page";
		}else {
			return "index.html";
		}
		
	}
	

	
	 
	
	
	

}
