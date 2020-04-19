package com.umd.webservicesProject.project2.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FinalResponeObject {
	private String userName;
	private String ServiceName;
	private String invocationTime;
	private String invocationDate;
	public FinalResponeObject() {
		
	}
	
	public FinalResponeObject(String userName, String serviceName, String invocationTime, String invocationDate) {
		super();
		this.userName = userName;
		ServiceName = serviceName;
		this.invocationTime = invocationTime;
		this.invocationDate = invocationDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getServiceName() {
		return ServiceName;
	}
	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}
	public String getInvocationTime() {
		return invocationTime;
	}
	public void setInvocationTime(String invocationTime) {
		this.invocationTime = invocationTime;
	}
	public String getInvocationDate() {
		return invocationDate;
	}
	public void setInvocationDate(String invocationDate) {
		this.invocationDate = invocationDate;
	}

}
