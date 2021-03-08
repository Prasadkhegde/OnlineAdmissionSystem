package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.entities.Payment;

@Service
public interface IPaymentServices {
	public Payment addPayment(Payment payment);
	
	public ArrayList<Payment> viewAllPaymentDetails();
	
	public  ArrayList<Payment> getPaymentDetailsByEmail (String emailId);
	
	public  Payment getPaymentDetailsByPaymentId (int paymentId); 
	
	public  Payment getPaymentDetailsByApplicationId(int applicationId);
	
	public ArrayList<Payment> getPayementDetailsByStatus(String paymentStatus);
	
	public int deletePaymentById(int paymentById);
	
	public Payment  updatePaymentDetails(Payment payment);

}
