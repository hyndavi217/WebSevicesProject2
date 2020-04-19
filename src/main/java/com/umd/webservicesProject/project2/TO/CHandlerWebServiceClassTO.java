package com.umd.webservicesProject.project2.TO;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CHandlerWebServiceClassTO {
	private String userName;
	private String responseChar;
	public CHandlerWebServiceClassTO() {}
	public CHandlerWebServiceClassTO(String userName, String responseChar) {
		super();
		this.userName = userName;
		this.responseChar = responseChar;
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

}
