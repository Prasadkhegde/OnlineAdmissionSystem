package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.entities.Payment;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.services.IPaymentServicesImpl;

@SpringBootTest
class IPaymentServicesTest {

	
	@Autowired
	IPaymentServicesImpl iPaymentServicesImpl;
	
	@Test
	public void testAddRoomDetails() {
		LocalDate time = LocalDate.now();
		Payment payment = new Payment("Ajay@gmail.coom",0.0,"Not Paid",time,"Payment Failed");
		iPaymentServicesImpl.addPayment(payment);
	}
	
	
//	@Test
	public void testViewAllPaymentDetails() {
		iPaymentServicesImpl.viewAllPaymentDetails();
	}
	
//	@Test
	public void testGetPaymentDetailsByEmail() {
		iPaymentServicesImpl.getPaymentDetailsByEmail("Ajay@gmail.coom");
	}
	
//	@Test
	public void testGetPaymentDetailsByPaymentId() {
		iPaymentServicesImpl.getPaymentDetailsByPaymentId(0);
	}
	
//	@Test
	public void testGetPaymentDetailsByApplicationId() {
		iPaymentServicesImpl.getPaymentDetailsByApplicationId(0);
	}
	
	//@Test
	public void testGetPayementDetailsByStatus() {
		iPaymentServicesImpl.getPayementDetailsByStatus("Payment approved");
	}
	
//	@Test
	public void testDeletePaymentById() {
		iPaymentServicesImpl.deletePaymentById(0);
	}
	
	
//	@Test
	public void testUpdatePaymentDetails() {
		LocalDate time = LocalDate.now();
		Payment payment = new Payment("Ajay@gmail.coom",55200.00,"Paid",time,"Payment approved");
		iPaymentServicesImpl.updatePaymentDetails(payment);
	}
	
}
