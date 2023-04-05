package com.onlinegrocery.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.onlinegrocery.enums.PaymentType;



@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paymentId;
	private double amount;
	private PaymentType type;
	
	public Payment() {
		super();
		
	}
	public Payment(long paymentId, double amount, PaymentType type) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.type = type;
	}
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public PaymentType getType() {
		return type;
	}
	public void setType(PaymentType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", amount=" + amount + ", type=" + type + "]";
	}
	
	
}
