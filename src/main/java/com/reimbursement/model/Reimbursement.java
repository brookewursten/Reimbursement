package com.reimbursement.model;

import java.time.LocalDateTime;

public final class Reimbursement {
	public static enum status {PENDING, ACCEPTED, REJECTED};
	public static enum type {GAS("gas mileage"),TRAVEL("travel and lodging"),FOOD("meals and entertainment"),TOOLS("tools and supplies"),TRAINING("training and licensing"),MISC("miscellaneous");
		private String typeName;
		type(String t) {
			this.typeName = t;
		}
		public String getTypeName() {
			return typeName;
		}
	
	};
	private int id;
	private float amount;
	private LocalDateTime submitted;
	private LocalDateTime resolved;
	private String description;
	private byte[] receipt;
	private int author;
	private int resolver;
	private status reimbursementStatus;
	private type reimType;
	
	
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(float amount, String description, byte[] receipt, int author,
			status reimbursementStatus, type rType) {
		super();
		this.amount = amount;
		this.description = description;
		this.setReceipt(receipt);
		this.author = author;
		this.reimbursementStatus = reimbursementStatus;
		this.reimType = rType;
	}



	public Reimbursement(int id, float amount, LocalDateTime submitted, LocalDateTime resolved, String description, byte[] receipt,
			int author, int resolver, status reimbursementStatus, type rtype) {
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
		this.reimType = rtype;
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




	public byte[] getReceipt() {
		return receipt;
	}

	public void setReceipt(byte[] receipt) {
		this.receipt = receipt;
	}

	public type getReimType() {
		return reimType;
	}

	public void setReimType(type reimType) {
		this.reimType = reimType;
	}

}
