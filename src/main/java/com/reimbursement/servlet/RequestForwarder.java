package com.reimbursement.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimbursement.controller.EmployeeController;
import com.reimbursement.controller.LoginController;
import com.reimbursement.controller.ManagerController;

public class RequestForwarder extends HttpServlet {
	public String routes(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		String uri = req.getRequestURI().substring(29);
		switch (uri){
		case "/login.page":
			return new LoginController().login(req,session);
		default: 
			return "./index.html";
		}
	}
	
	public void data(HttpServletRequest req, HttpServletResponse res,HttpSession ses) throws IOException {
		String uri = req.getRequestURI().substring(29);
		switch(uri) {
		case "/all.json":
			new ManagerController().sendReimbursements(res);
			break;
		case "/mine.json":
			new EmployeeController().sendReimbursements(res,ses);
			break;
		case "/manager.json":
			new ManagerController().acceptOrReject(req, res,ses);
			break;
		case "/employee.json":
			new EmployeeController().newReimbursement(req,res,ses);
		
				
		}
	}

}
