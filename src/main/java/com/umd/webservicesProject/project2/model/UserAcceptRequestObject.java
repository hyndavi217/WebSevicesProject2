package com.umd.webservicesProject.project2.model;

public class UserAcceptRequestObject {
	private String userName;
	private String fileName;
	private String service;
	private boolean firstTimeRequest;
	private String lastProcessedCharacter;

	public UserAcceptRequestObject() {
	}

	public UserAcceptRequestObject(String userName, String fileName, String service) {
		super();
		this.userName = userName;
		this.fileName = fileName;
		this.service = service;
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

	public boolean isFirstTimeRequest() {
		return firstTimeRequest;
	}

	public void setFirstTimeRequest(boolean firstTimeRequest) {
		this.firstTimeRequest = firstTimeRequest;
	}

	public String getLastProcessedCharacter() {
		return lastProcessedCharacter;
	}

	public void setLastProcessedCharacter(String lastProcessedCharacter) {
		this.lastProcessedCharacter = lastProcessedCharacter;
	}

}
