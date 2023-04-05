package com.onlinegrocery.service;

import java.util.List;

import com.onlinegrocery.dto.OrderDto;
import com.onlinegrocery.entity.Order;
import com.onlinegrocery.enums.Status;
import com.onlinegrocery.exceptions.OrderNotFoundException;





public interface OrderService{
	
	public OrderDto updateStatus(long orderId, Status status )throws OrderNotFoundException;
	public List<OrderDto> vieworderbyStatus(Status status)throws OrderNotFoundException;
	
	
	
	public Order placeOrder(Order order);
	public String cancelOrder(Long orderId) throws OrderNotFoundException;
	public List<Order> viewOrder();

}
