package com.reimbursement.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.model.Reimbursement;
import com.reimbursement.service.EmployeeService;
import com.reimbursement.uio.EmployeeUio;

public class EmployeeController {
	EmployeeService es;
	
	public EmployeeController(EmployeeService es) {
		super();
		this.es = es;
	}
	
	
	public EmployeeController() {
		this(new EmployeeService());
	}

	public void sendReimbursements(HttpServletResponse res,HttpSession ses) {
		res.setContentType("text/json");
		int id = (int) ses.getAttribute("userId");
		ArrayList<EmployeeUio> reims = es.getMyReimbursements(id);
		try {
			res.getWriter().println(new ObjectMapper().writeValueAsString(reims));
		} catch (IOException e) {
		}
		
	}

	public void newReimbursement(HttpServletRequest req, HttpServletResponse res, HttpSession ses) throws IOException { 
		try { 
			int userId = (int) ses.getAttribute("userId");
			EmployeeUio uio = new ObjectMapper().readValue(req.getInputStream(),EmployeeUio.class); 
			Reimbursement r = new Reimbursement();
			es.createReimbursement(r);

		} catch (IOException e) { e.printStackTrace();
		res.getWriter().println("something went wrong"); 
		}

	}

}
