package com.umd.webservicesProject.project2.model;

import java.io.File;
import java.util.List;

public class User {
	
	private String UserName;
	private List<String> service;
	private File FileWithProtocol;
	
	public User() {
		
	}
	public User(String UserName,List<String> service,File FileWithProtocol) {
	this.UserName=UserName;
		this. service =service;
		this.FileWithProtocol=FileWithProtocol;
	}
	public File getFileWithProtocol() {
		return FileWithProtocol;
	}
	public void setFileWithProtocol(File fileWithProtocol) {
		FileWithProtocol = fileWithProtocol;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public List<String> getService() {
		return service;
	}
	public void setService(List<String> service) {
		this.service = service;
	}
	@Override
	public String toString() {
		return "User [UserName=" + UserName + ", service=" + service + ", FileWithProtocol=" + FileWithProtocol + "]";
	}
	
	

}
