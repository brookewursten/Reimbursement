package com.reimbursement.uio;

import java.time.LocalDateTime;

import com.reimbursement.model.Reimbursement.status;
import com.reimbursement.model.Reimbursement.type;

public class ManagerUio {
	private int reimId;
	private float amount;
	private LocalDateTime submitted;
	private LocalDateTime resolved;
	private String description;
	private byte[] receipt;
	private String authorName;
	private status reimbursementStatus;
	private type reimType;
	
	public ManagerUio(int reimId, float amount, LocalDateTime submitted, LocalDateTime resolved, String description,
			byte[] receipt, String authorName, status reimbursementStatus, type reimType) {
		super();
		this.reimId = reimId;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.authorName = authorName;
		this.reimbursementStatus = reimbursementStatus;
		this.reimType = reimType;
	}

	public int getReimId() {
		return reimId;
	}

	public void setReimId(int reimId) {
		this.reimId = reimId;
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

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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
