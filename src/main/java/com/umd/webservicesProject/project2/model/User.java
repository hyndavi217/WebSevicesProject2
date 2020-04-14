package com.umd.webservicesProject.project2.model;

import java.util.List;

public class User {
	
	private String UserName;
	private List<String> services;
	
	public User() {
		
	}
	public User(String UserName,List<String> services) {
	this.UserName=UserName;
		this. services =services;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public List<String> getServices() {
		return services;
	}
	public void setServices(List<String> services) {
		this.services = services;
	}
	@Override
	public String toString() {
		return "User [UserName=" + UserName + ", services=" + services + "]";
	}
	

}
