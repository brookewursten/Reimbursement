package com.reimbursement.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class EnvironmentConnectionUtil {
	private String url = System.getenv("url");
	private String username = System.getenv("username");
	private String password = System.getenv("password");

	private static EnvironmentConnectionUtil instance;

	public static EnvironmentConnectionUtil getInstance() {
		if (instance == null) {
			instance = new EnvironmentConnectionUtil();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
