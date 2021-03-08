package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Application {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int applicationId;
	
	private String emailId = "Ajay@domainname.com";
	
	public Application() {}

	public Application(int applicationId, String emailId) {
		super();
		this.applicationId= applicationId;
		this.emailId = emailId;
	}

	public int getApplicationID() {
		return applicationId;
	}

	public void setApplicationID(int applicationId) {
		this.applicationId = applicationId;
	}

	@Override
	public String toString() {
		return "Application [applicationID=" + applicationId+ ", emailId=" + emailId + "]";
	}
	
	
	
	

}
