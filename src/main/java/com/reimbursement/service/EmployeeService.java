package com.reimbursement.service;

import java.util.ArrayList;

import com.reimbursement.model.Reimbursement;
import com.reimbursement.model.User;
import com.reimbursement.repo.ReimbursementDao;
import com.reimbursement.repo.UserDao;
import com.reimbursement.uio.EmployeeUio;

public class EmployeeService {
	private ReimbursementDao rd;
	private UserDao ud;
	
	public EmployeeService(ReimbursementDao rd, UserDao ud) {
		this.rd = rd;
		this.ud = ud;
	}
	
	public EmployeeService() {
		this(new ReimbursementDao(),new UserDao());
	}
	
	
	
	
	
	
	
	public ArrayList<EmployeeUio> getMyReimbursements(int id){
		ArrayList<Reimbursement> reims = rd.findAllByUserId(id);
		ArrayList<User> users = ud.findAll();
		ArrayList<EmployeeUio> uios = new ArrayList<EmployeeUio>();
		
		EmployeeUio uio;
		String authorName;
	
		for(int i=0; i<reims.size();i++) {
			for(int j=0;j<users.size();j++) {
				if(reims.get(i).getResolverID() == users.get(j).getId()) {
					authorName = users.get(j).getFirstName() + " " + users.get(j).getLastName();
					uio = new EmployeeUio(reims.get(i).getId(),reims.get(i).getAmount(),reims.get(i).getSubmitted(),reims.get(i).getResolved(),reims.get(i).getDescription(),reims.get(i).getReceipt(),authorName,reims.get(i).getReimbursementStatus(),reims.get(i).getReimType());
					uios.add(uio);
				}
			}			
		}
		return uios;
	}
	
	public void updateReimbursement(Reimbursement r) {
		rd.update(r);
	}
	
	public void removeReimbursment(int id) {
		rd.delete(id);
	}
	
	public void createReimbursement(Reimbursement r) {
		rd.create(r);
	}
	
	
	
	
				
}
	


