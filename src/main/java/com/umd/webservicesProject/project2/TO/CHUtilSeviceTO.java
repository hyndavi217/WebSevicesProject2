package com.umd.webservicesProject.project2.TO;

import java.util.List;

public class CHUtilSeviceTO {
	private List<String> possibleServicesToSelect;
	private String finalChar;
	private String userName;
	private String twoByteService;

	public CHUtilSeviceTO() {

	}

	public CHUtilSeviceTO(List<String> possibleServicesToSelect, String finalChar, String userName) {
		super();
		this.possibleServicesToSelect = possibleServicesToSelect;
		this.finalChar = finalChar;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getPossibleServicesToSelect() {
		return possibleServicesToSelect;
	}

	public void setPossibleServicesToSelect(List<String> possibleServicesToSelect) {
		this.possibleServicesToSelect = possibleServicesToSelect;
	}

	public String getFinalChar() {
		return finalChar;
	}

	public void setFinalChar(String finalChar) {
		this.finalChar = finalChar;
	}

	public String getTwoByteService() {
		return twoByteService;
	}

	public void setTwoByteService(String twoByteService) {
		this.twoByteService = twoByteService;
	}

}
