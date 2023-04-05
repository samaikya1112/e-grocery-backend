package com.onlinegrocery.entity;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.onlinegrocery.enums.PaymentType;
import com.onlinegrocery.enums.Status;


@Entity
@Table(name= "orders")
public class Order { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private String userName;
	private double totalAmount;
	private Date orderDate;
	private Status status;
	@Embedded
	private Address address;
	private PaymentType paymentType;
	
	public Order() {
		super();
	}

	public Order(Long orderId, String userName, double totalAmount, Date orderDate, Status status, Address address,
			PaymentType paymentType) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
		this.status = status;
		this.address = address;
		this.paymentType = paymentType;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userName=" + userName + ", totalAmount=" + totalAmount + ", orderDate="
				+ orderDate + ", status=" + status + ", address=" + address + ", paymentType=" + paymentType + "]";
	}
	
	
}
