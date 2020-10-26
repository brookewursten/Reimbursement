package com.reimbursement.model;

public final class User {
	public static enum role {ADMIN , MANAGER, EMPLOYEE};
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private role userRole;
	
	
	public User() {
		super();
	}


	public User(int id, String username, String password, String firstName, String lastName, String email,
			role userRole) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public role getRole() {
		return userRole;
	}
	public void setRole(role role) {
		this.userRole = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}