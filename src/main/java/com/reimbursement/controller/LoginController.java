package com.reimbursement.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.ServletInputStream;
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
		String reqBody = "";
		try {
		BufferedReader reader = req.getReader();
		reqBody = reader.readLine();
		}catch(IOException e){
			System.out.println("sorry");
		}
		String[] bodySeparated = reqBody.split("&");		
		
		
		String username = bodySeparated[0].substring(9).trim();
		String password = bodySeparated[1].substring(5).trim();
		
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		User u = new User();
		
		try{
			u = ss.getUser(username);
		}catch(Exception e) {
			return "index.html";
		}
		System.out.println(encoder.matches(password,u.getPassword()));
		if(encoder.matches(password,u.getPassword())) {
			session.setAttribute("userId", u.getId());
			session.setAttribute("userRole", u.getRole().toString());
			return "reimburse.html";
		}else {
			return "index.html";
		}
		
	}
	

	
	 
	
	
	

}
