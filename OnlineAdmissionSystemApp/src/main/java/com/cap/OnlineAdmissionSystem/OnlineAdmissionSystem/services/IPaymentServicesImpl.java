package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.Exceptions.DeletionException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.Exceptions.NotFoundException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.Exceptions.PaymentAddException;
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
			Payment payment = paymentRepository.findPaymentDetailsByPaymentId(p.getId());
			if(payment == null) {
				paymentRepository.save(p);
				System.out.println(payment);
			}else {
					throw new PaymentAddException("Error in adding payment");
		}
		
		return payment;
	}

	@Override
	public List<Payment> viewAllPaymentDetails() {
		 List<Payment> payments = paymentRepository.findAll();
		 if(payments.isEmpty()) {
			 throw new NotFoundException("Details not found");
		 }
		 System.out.println(payments);
		 return payments;
		
	}

	@Override
	public ArrayList<Payment> getPaymentDetailsByEmail(String emailId) {
		ArrayList<Payment> payments = paymentRepository.findPaymentDetailsByEmailId(emailId);
		if(payments.isEmpty()) {
			 throw new NotFoundException("Details not found");
		 }
		System.out.println(payments);
		return payments;
	}

	@Override
	public Payment getPaymentDetailsByPaymentId(int paymentId) {
		Optional<Payment> payment = paymentRepository.findById(paymentId);
		if(payment.isEmpty()) {
			 throw new NotFoundException("Details not found");
		 }
		System.out.println(payment);
		return payment.get();
	}

	@Override
	public List<Payment> getPaymentDetailsByApplicationId(int applicationId) {
		List<Payment> payments = paymentRepository.findPaymentDetailsByApplicationId(applicationId);
		if(payments.isEmpty()) {
			 throw new NotFoundException("Details not found");
		 }
		System.out.println(payments);
		return payments;
	}

	@Override
	public ArrayList<Payment> getPayementDetailsByStatus(String paymentStatus) {
		ArrayList<Payment> payments = paymentRepository.findPayementDetailsByPaymentStatus(paymentStatus);
		if(payments.isEmpty()) {
			 throw new NotFoundException("Details not found");
		 }
		System.out.println(payments);
		return payments;
	}

	@Override
	public Payment deletePaymentById(int paymentId) {
	Optional<Payment> payment = paymentRepository.findById(paymentId);
	if(payment.isEmpty()) {
		throw new DeletionException("Error in deleting not existing object");
	}
	Payment p = payment.get();
	paymentRepository.delete(p);
		return p;
	}
	
	@Override
	@Transactional
	public Payment updatePaymentDetails(Payment p) {
			Optional<Payment> payment= paymentRepository.findById(p.getPaymentId());
			Payment p1=null;
			if(payment.isPresent()) {
				p1=payment.get();
				paymentRepository.save(p1);
			}
			return p1;

	}
}
