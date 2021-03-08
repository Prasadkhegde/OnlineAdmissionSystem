package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.services;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.entities.Payment;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.repos.IApplicationRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.repos.IPaymentRepository;


@Service
public class IPaymentServicesImpl implements IPaymentServices{
	
	@Autowired
	IPaymentRepository paymentRepository;
	
	@Autowired
	IApplicationRepository applicationRepo;
	
	@Transactional
	public Payment addPayment(Payment p) {
		Optional<Payment> payment = paymentRepository.findById(p.getId());
		if(payment != null) {
			paymentRepository.save(p);
		}else {System.out.println("Error in adding payment");
		}
		
		return p;
	}

	@Override
	public ArrayList<Payment> viewAllPaymentDetails() {
		return (ArrayList<Payment>) paymentRepository.findAll();
	}

	@Override
	public ArrayList<Payment> getPaymentDetailsByEmail(String emailId) {
		return paymentRepository.findPaymentDetailsByEmailId(emailId);
	}

	@Override
	public Payment getPaymentDetailsByPaymentId(int paymentId) {
		return paymentRepository.findPaymentDetailsByPaymentId(paymentId);
	}

	@Override
	public Payment getPaymentDetailsByApplicationId(int id) {
		return null;
	}

	@Override
	public ArrayList<Payment> getPayementDetailsByStatus(String paymentStatus) {
		return paymentRepository.findPayementDetailsByPaymentStatus(paymentStatus);
	}

	@Override
	public int deletePaymentById(int paymentId) {
		return paymentRepository.deleteByPaymentId(paymentId);
	}

	@Transactional
	public Payment updatePaymentDetails(Payment payment) {
		Optional<Payment> getUpdatePaymentDetails = paymentRepository.findById(payment.getId());
		Payment updatePayment = null;
		if(getUpdatePaymentDetails.isPresent()) {
			updatePayment = getUpdatePaymentDetails.get();
		if(payment.getPaymentAmount() != 0.0) {
			updatePayment.setPaymentAmount(payment.getPaymentAmount());
		}
		if(payment.getEmailId()!=null) {
			updatePayment.setEmailId(payment.getEmailId());
		}
		if(payment.getPaymentDescription()!=null) {
			updatePayment.setPaymentDescription(payment.getPaymentDescription());
		}
		}
		return updatePayment;
		
	}


	
	

}
