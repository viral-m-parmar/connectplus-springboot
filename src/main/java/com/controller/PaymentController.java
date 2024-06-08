package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.PaymentEntity;
import com.repository.PaymentRepository;

@RestController
@RequestMapping("doctor")
public class PaymentController {

	@Autowired
	PaymentRepository paymentRepo;

	@PostMapping("/addPaymentDetail")
	public ResponseEntity<?> addPaymentDetail(@RequestBody PaymentEntity payment) {

		paymentRepo.save(payment);
		return ResponseEntity.ok(payment);
	}

	@GetMapping("/getAllPayments")
	public ResponseEntity<?> getAllPayments() {

		List<PaymentEntity> payments = paymentRepo.findAll();
		return ResponseEntity.ok(payments);
	}

	@GetMapping("/getPaymentDetailById/{paymentId}")
	public ResponseEntity<?> getPaymentDetailById(@PathVariable("paymentId") Integer paymentId) {

		PaymentEntity payment = paymentRepo.findById(paymentId).get();
		return ResponseEntity.ok(payment);
	}

	@DeleteMapping("/deletePaymentById/{paymentId}")
	public ResponseEntity<?> deletePaymentById(@PathVariable("paymentId") Integer paymentId) {

		PaymentEntity payment = paymentRepo.findById(paymentId).get();
		paymentRepo.deleteById(paymentId);
		return ResponseEntity.ok(payment);
	}
	
	@PutMapping("/updatePayment")
	public ResponseEntity<?> updatePayment(@RequestBody PaymentEntity payment){
		
		PaymentEntity oldPayment = paymentRepo.findById(payment.getPaymentId()).get();
		
		if(payment.getPatient() != null) {
			oldPayment.setPatient(payment.getPatient());
		}
		if(payment.getTranscationRef() != null) {
			oldPayment.setTranscationRef(payment.getTranscationRef());
		}
		if(payment.getDate() != null) {
			oldPayment.setDate(payment.getDate());
		}
		if(payment.getAmount() != null) {
			oldPayment.setAmount(payment.getAmount());
		}
		if(payment.getRemarks() != null) {
			oldPayment.setRemarks(payment.getRemarks());
		}
		if(payment.getDiscount() != null) {
			oldPayment.setDiscount(payment.getDiscount());
		}
		if(payment.getDiscountRef() != null) {
			oldPayment.setDiscountRef(payment.getDiscountRef());
		}
		
		paymentRepo.save(oldPayment);
		return ResponseEntity.ok(oldPayment);
	}

}
