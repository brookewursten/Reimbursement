package com.reimbursement.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.service.ManagerService;
import com.reimbursement.uio.ManagerUio;

public class ManagerController {
	ManagerService ms;
	
	public ManagerController(ManagerService ms) {
		super();
		this.ms = ms;
	}
	
	public ManagerController() {
		this(new ManagerService());
	}
	
	
	
	public void sendReimbursements(HttpServletResponse res) {
		res.setContentType("text/json");
		ArrayList<ManagerUio> reims = ms.getReimbursements();
		try {
			res.getWriter().println(new ObjectMapper().writeValueAsString(reims));
		} catch (IOException e) {
		}
	}
	
	
	public void acceptOrReject(HttpServletRequest req, HttpServletResponse res,HttpSession ses) throws IOException {
		try {
			ObjectMapper om = new ObjectMapper();
			int id = (int) om.readValue(req.getInputStream(), Integer.class);
			boolean isAccepted = (boolean) om.readValue(req.getInputStream(), Boolean.class);
			System.out.println(id);
			System.out.println(isAccepted);
			ms.acceptOrReject(id,(int) ses.getAttribute("userId"),isAccepted);
			
		} catch (IOException e) {
			e.printStackTrace();
			res.getWriter().println("something went wrong");
		}
	}

}
