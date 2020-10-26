package com.reimbursement.model;

import java.time.LocalDateTime;

public final class Reimbursement {
	public static enum status {PENDING, ACCEPTED, REJECTED};
	private int id;
	private float amount;
	private LocalDateTime submitted;
	private LocalDateTime resolved;
	private String description;
	private byte[] receipt;
	private int author;
	private int resolver;
	private status reimbursementStatus;
	private String type;
	
	
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(int id, float amount, LocalDateTime submitted, String description, byte[] receipt, int author,
			status reimbursementStatus, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		this.setReceipt(receipt);
		this.author = author;
		this.reimbursementStatus = reimbursementStatus;
		this.type = type;
	}



	public Reimbursement(int id, float amount, LocalDateTime submitted, LocalDateTime resolved, String description, byte[] receipt,
			int author, int resolver, status reimbursementStatus, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.setReceipt(receipt);
		this.author = author;
		this.resolver = resolver;
		this.reimbursementStatus = reimbursementStatus;
		this.type = type;
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



	public int getAuthorID() {
		return author;
	}



	public void setAuthorID(int author) {
		this.author = author;
	}



	public int getResolverID() {
		return resolver;
	}



	public void setResolverID(int resolver) {
		this.resolver = resolver;
	}



	public status getReimbursementStatus() {
		return reimbursementStatus;
	}



	public void setReimbursementStatus(status reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}

	public byte[] getReceipt() {
		return receipt;
	}

	public void setReceipt(byte[] receipt) {
		this.receipt = receipt;
	}

}
