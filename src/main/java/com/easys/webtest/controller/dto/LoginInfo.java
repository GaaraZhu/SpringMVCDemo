package com.easys.webtest.controller.dto;

public class LoginInfo {

	private String username;

	private String password;

	public LoginInfo() {
	}

	public LoginInfo(String userName, String password) {
		super();
		this.username = userName;
		this.password = password;
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

}
