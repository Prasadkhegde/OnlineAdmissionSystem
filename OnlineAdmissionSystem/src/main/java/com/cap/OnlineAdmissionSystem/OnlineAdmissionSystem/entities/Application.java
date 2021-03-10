package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Application {
	
	
	@Id
	@SequenceGenerator(name = "application_sequence",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "application_sequence")
	private int applicationId;
	
	private String emailId;
	
	public Application() {}

	public Application(String emailId) {
		super();
		this.emailId = emailId;
	}

	public int getApplicationID() {
		return applicationId;
	}

	public void setApplicationID(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Application [applicationID=" + applicationId+ ", emailId=" + emailId + "]";
	}
	
	
	
	

}
