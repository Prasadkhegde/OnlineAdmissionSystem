package com.OnlineAdmissionSystemDemo.App.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.OnlineAdmissionSystemDemo.App.entities.Payment;

@Service
public interface IPaymentServices {
	public Payment addPayment(Payment payment);
	
	public List<Payment> viewAllPaymentDetails();
	
	public  ArrayList<Payment> getPaymentDetailsByEmail (String emailId);
	
	
	public  Payment getPaymentDetailsByPaymentId (int paymentId); 
	
	public  List<Payment> getPaymentDetailsByApplicationId(int applicationId);
	
	public ArrayList<Payment> getPayementDetailsByStatus(String paymentStatus);
	
	public Payment deletePaymentById(int paymentById);
	
	public Payment  updatePaymentDetails(Payment payment);

}
