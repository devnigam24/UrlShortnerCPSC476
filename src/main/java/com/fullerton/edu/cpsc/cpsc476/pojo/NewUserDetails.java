package com.fullerton.edu.cpsc.cpsc476.pojo;

import java.util.HashMap;

public class NewUserDetails {
	private String username;
	private String emailID;
	private String password;
	private Boolean isGuestUser;
	private HashMap<String, String> urlShorner;
	private HashMap<String, Integer> urlShornerUrlCount;

	public HashMap<String, Integer> getUrlShornerUrlCountMap() {
		return urlShornerUrlCount;
	}

	public HashMap<String, String> getUrlShornerMap() {
		return this.urlShorner;
	}

	public NewUserDetails(String username, String emailID, String password, Boolean isGuestUser) {
		this.username = username;
		this.password = password;
		this.emailID = emailID;
		this.isGuestUser = isGuestUser;
		this.urlShorner = new HashMap<String, String>();
		this.urlShornerUrlCount = new HashMap<String, Integer>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsGuestUser() {
		return isGuestUser;
	}

	public void setIsGuestUser(Boolean isGuestUser) {
		this.isGuestUser = isGuestUser;
	}
}
