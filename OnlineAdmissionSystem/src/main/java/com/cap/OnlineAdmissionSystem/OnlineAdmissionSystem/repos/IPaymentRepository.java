package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem.entities.Payment;


@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer>{


	public  ArrayList<Payment> findPaymentDetailsByEmailId(String emailId);	

	public  Payment findPaymentDetailsByPaymentId(int paymentId);	

//	public  Payment findPaymentDetailsByApplicationId(int applicationId);

	public ArrayList<Payment> findPayementDetailsByPaymentStatus(String paymentStatus);

	public int deleteByPaymentId(int paymentId);

}
