package com.reimbursement.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.reimbursement.repo.ReimbursementDao;
import com.reimbursement.repo.UserDao;
import com.reimbursement.uio.ManagerUio;
import com.reimbursement.model.*;
import com.reimbursement.model.Reimbursement.status;

public class ManagerService {
	private ReimbursementDao rd;
	private UserDao ud;
	
	
	
	
	public ManagerService(ReimbursementDao rd, UserDao ud) {
		super();
		this.rd = rd;
		this.ud = ud;
	}




	public ManagerService() {
		this(new ReimbursementDao(),new UserDao());
	}
	
	
	
	
	public ArrayList<ManagerUio> getReimbursements(){
		ArrayList<Reimbursement> reims = rd.findAll();
		ArrayList<User> users = ud.findAll();
		ArrayList<ManagerUio> uios = new ArrayList<ManagerUio>();
		
		ManagerUio uio;
		String authorName;
	
		for(int i=0; i<reims.size();i++) {
			for(int j=0;j<users.size();j++) {
				if(reims.get(i).getAuthorID() == users.get(j).getId()) {
					authorName = users.get(j).getFirstName() + " " + users.get(j).getLastName();
					uio = new ManagerUio(reims.get(i).getId(),reims.get(i).getAmount(),reims.get(i).getSubmitted(),reims.get(i).getResolved(),reims.get(i).getDescription(),reims.get(i).getReceipt(),authorName,reims.get(i).getReimbursementStatus(),reims.get(i).getReimType());
					uios.add(uio);
				}
			}			
		}
		return uios;
	}
	
	public void acceptOrReject(int reim_id,int manager_id, boolean isAccepted) {
		Reimbursement r = rd.findById(reim_id);
		if(isAccepted) {
			r.setReimbursementStatus(status.ACCEPTED);			
		} else {
			r.setReimbursementStatus(status.REJECTED);
		}
		r.setResolverID(manager_id);
		r.setResolved(LocalDateTime.now());
		rd.update(r);
	}
	
	

}
