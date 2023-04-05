package com.onlinegrocery.dto;

import java.util.Date;

import com.onlinegrocery.enums.Status;



public class OrderDto {
	private Long orderId;
	private String userName;
	private double totalAmount;
	private Date orderDate;
	private Status status;
	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDto(Long orderId, String userName, double totalAmount, Date orderDate, Status status) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
		this.status = status;
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
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userName=" + userName + ", totalAmount=" + totalAmount + ", orderDate="
				+ orderDate + ", status=" + status + "]";
	}
	
	
}
