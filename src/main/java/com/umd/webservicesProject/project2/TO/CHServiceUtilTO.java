package com.umd.webservicesProject.project2.TO;

public class CHServiceUtilTO {
	private String responseChar;
	private String selectedService;
	private String filePath;
	private String userName;
	
	public CHServiceUtilTO() {}
	
	public CHServiceUtilTO(String responseChar, String selectedService, String filePath,String userName) {
		super();
		this.responseChar = responseChar;
		this.selectedService = selectedService;
		this.filePath = filePath;
		this.userName= userName;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getResponseChar() {
		return responseChar;
	}
	public void setResponseChar(String responseChar) {
		this.responseChar = responseChar;
	}
	public String getSelectedService() {
		return selectedService;
	}
	public void setSelectedService(String selectedService) {
		this.selectedService = selectedService;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	

}
