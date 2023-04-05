package com.onlinegrocery.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinegrocery.dto.OrderDto;
import com.onlinegrocery.entity.Order;
import com.onlinegrocery.enums.Status;
import com.onlinegrocery.exceptions.OrderNotFoundException;
import com.onlinegrocery.service.OrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;




@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderservice;
	
	@PutMapping("/updateStatus/{orderId}")
	public OrderDto updateStatus(long orderId, Status status )throws OrderNotFoundException{
		return orderservice.updateStatus(orderId, status);
	}
	
	@GetMapping("/viewOrderByStatus")
	public List<OrderDto> vieworderbyStatus(Status status)throws OrderNotFoundException{
		return orderservice.vieworderbyStatus(status);
	}
	
	@PostMapping("/placeOrder/useAddress")
	public Order placeOrder(@RequestBody Order order) {
		return orderservice.placeOrder(order);
	}
	
	
	//Cancel Order
	@DeleteMapping("/cancelOrder/{orderId}")
	public String cancelOrder(@PathVariable long orderId) throws OrderNotFoundException {
		String cancelOrder = this.orderservice.cancelOrder(orderId);
		return cancelOrder;
	}

	//View Order
	@GetMapping("/viewOrder")
	public List<Order> viewOrder() {
		List<Order> viewOrder = this.orderservice.viewOrder();
		return viewOrder;
	}
}
