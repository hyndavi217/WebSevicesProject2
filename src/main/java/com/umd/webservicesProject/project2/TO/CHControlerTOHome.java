package com.umd.webservicesProject.project2.TO;

import java.util.List;

public class CHControlerTOHome {
	private String finalResponseObject;
	private List<String> possibleServicesList;
	private String fileName;
	private String userName;
	private String lastProcessedCharacter;

	public CHControlerTOHome() {

	}

	public CHControlerTOHome(String finalResponseObject, List<String> possibleServicesList, String fileName,
			String userName) {
		super();
		this.finalResponseObject = finalResponseObject;
		this.possibleServicesList = possibleServicesList;
		this.fileName = fileName;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFinalResponseObject() {
		return finalResponseObject;
	}

	public void setFinalResponseObject(String finalResponseObject) {
		this.finalResponseObject = finalResponseObject;
	}

	public List<String> getPossibleServicesList() {
		return possibleServicesList;
	}

	public void setPossibleServicesList(List<String> possibleServicesList) {
		this.possibleServicesList = possibleServicesList;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getLastProcessedCharacter() {
		return lastProcessedCharacter;
	}

	public void setLastProcessedCharacter(String lastProcessedCharacter) {
		this.lastProcessedCharacter = lastProcessedCharacter;
	}

}
