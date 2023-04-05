package com.onlinegrocery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinegrocery.dto.PaymentDto;
import com.onlinegrocery.entity.Payment;
import com.onlinegrocery.serviceImpl.PaymentServiceImpl;


@RestController
@RequestMapping("/Payment")
public class PaymentController {
	@Autowired
	private PaymentServiceImpl iPaymentService;
	
	@PostMapping("/payBill")
	public PaymentDto payBill(@RequestBody @Valid PaymentDto paymentDTO ) {
		return iPaymentService.payBill(paymentDTO);
	}
	
	@GetMapping("/viewBill")
	public List<Payment> viewBill() {
		return iPaymentService.viewBill();
	}
	
}








