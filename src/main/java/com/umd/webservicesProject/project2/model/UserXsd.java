package com.umd.webservicesProject.project2.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserXsd {
	private String userName;
	private String fileName;
	private String service;
	public UserXsd() {
		
	}
	public UserXsd(String puserName,String pfileName,String pservice) {
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}

}
