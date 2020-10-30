package com.reimbursement.uio;

import java.time.LocalDateTime;

import com.reimbursement.model.Reimbursement.status;
import com.reimbursement.model.Reimbursement.type;

public class EmployeeUio {
	
	private int id;
	private float amount;
	private LocalDateTime submitted;
	private LocalDateTime resolved;
	private String description;
	private byte[] receipt;
	private String resolver;
	private status reimbursementStatus;
	private type reimType;
	
	public EmployeeUio(int id, float amount, LocalDateTime submitted, LocalDateTime resolved, String description,
			byte[] receipt, String resolver, status reimbursementStatus, type reimType) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.resolver = resolver;
		this.reimbursementStatus = reimbursementStatus;
		this.reimType = reimType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public LocalDateTime getSubmitted() {
		return submitted;
	}

	public void setSubmitted(LocalDateTime submitted) {
		this.submitted = submitted;
	}

	public LocalDateTime getResolved() {
		return resolved;
	}

	public void setResolved(LocalDateTime resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getReceipt() {
		return receipt;
	}

	public void setReceipt(byte[] receipt) {
		this.receipt = receipt;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	public status getReimbursementStatus() {
		return reimbursementStatus;
	}

	public void setReimbursementStatus(status reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}

	public type getReimType() {
		return reimType;
	}

	public void setReimType(type reimType) {
		this.reimType = reimType;
	}

}
