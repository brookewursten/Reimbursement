package com.reimbursement.service;

import com.reimbursement.model.User;
import com.reimbursement.repo.UserDao;

public class SystemService {
	public UserDao ud;
	
	public SystemService(UserDao ud) {
		this.ud = ud;
		
	}
	
	public SystemService() {
		this(new UserDao());
	}
	
	public User getUser(String username) {
		return ud.findByUsername(username);
		
	}

}
