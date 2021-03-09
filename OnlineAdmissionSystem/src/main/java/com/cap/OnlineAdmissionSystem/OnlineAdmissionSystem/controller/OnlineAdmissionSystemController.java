package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.entities.Payment;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.repos.IPaymentRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.services.IPaymentServices;

@RestController
@RequestMapping(path = "/api/v1")
public class OnlineAdmissionSystemController {

	@Autowired
	IPaymentRepository paymentRepository;
	
	@Autowired
	IPaymentServices paymentServices;
	
	Optional<Payment> payments = null;
	
	
	
	@PostMapping("/payments")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Payment addPayment(@RequestBody Payment payment) {
		System.out.println(payment);
		return paymentServices.addPayment(payment);	
	}
	
	
	
	@GetMapping("/payments")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Payment> viewAllPaymentDetails(){
		return paymentServices.viewAllPaymentDetails();
	}
	
	@GetMapping("/paymentsByEmailId/{emailId}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Payment> getPaymentDetailsByEmail(@PathVariable("emailId") String emailId){
		return paymentServices.getPaymentDetailsByEmail(emailId);
	}
	
	@GetMapping("/paymentsByPaymentId/{paymentId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Payment getPaymentDetailsByPaymentId(@PathVariable("paymentId") int paymentId){
		return paymentServices.getPaymentDetailsByPaymentId(paymentId);
	}
	
	@GetMapping("/paymentsByApplicationId/{applicationId}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Payment> getPaymentDetailsByApplicationId(@PathVariable("applicationId") int applicationId){
		return paymentServices.getPaymentDetailsByApplicationId(applicationId);
	}
	
	@GetMapping("/paymentsByStatus/{paymentStatus}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Payment> getPayementDetailsByStatus(@PathVariable("paymentStatus") String paymentStatus){
		return paymentServices.getPayementDetailsByStatus(paymentStatus);
	}
	
	@DeleteMapping("/{paymentId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Payment deletePayment(@PathVariable("paymentId") int paymentId) {
			return paymentServices.deletePaymentById(paymentId);
	}
	
	@PutMapping("/payments")
	@ResponseStatus(code = HttpStatus.OK)
	public Payment updatePaymentDetails(@RequestBody Payment payment) {
		return paymentServices.updatePaymentDetails(payment);
	}
	
	
	
}
