package com.onlinegrocery.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.onlinegrocery.dto.OrderDto;
import com.onlinegrocery.entity.Order;
import com.onlinegrocery.enums.Status;
import com.onlinegrocery.exceptions.OrderNotFoundException;
import com.onlinegrocery.repo.OrderRepo;
import com.onlinegrocery.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepo orderRepo;

	@Override
	public OrderDto updateStatus(long orderId, Status status) throws OrderNotFoundException {
		Optional<Order> orderEntity = orderRepo.findById(orderId);
		if (orderEntity.isEmpty()) {
		throw new OrderNotFoundException ("Order not found : " + orderId);
		}else{
			Order order =  this.orderRepo.findById(orderId).get();
			order.setStatus(status);
			order=this.orderRepo.save(order);
			OrderDto neworderdto = new OrderDto();
			neworderdto.getStatus();
			BeanUtils.copyProperties(order, neworderdto);
			neworderdto.setStatus(order.getStatus());
			return neworderdto;
		}
		
	}
	@Override
		public List<OrderDto> vieworderbyStatus(Status status) throws OrderNotFoundException {
			List<Order> orderEntities = orderRepo.findByStatus(status); 
			List<OrderDto> orderdtos = new ArrayList<>();
			for (Order orderEntity : orderEntities) {

			// Create DTO from entity
			orderdtos.add(new OrderDto(orderEntity.getOrderId(),orderEntity.getUserName(),
			orderEntity.getTotalAmount(), orderEntity.getOrderDate(),orderEntity.getStatus()));
			}
			return orderdtos;
	}

	@Override
	public Order placeOrder(Order order) {
		Order save = this.orderRepo.save(order);
		return save;
	}

	@Override
	public String cancelOrder(Long orderId) throws OrderNotFoundException {
		if(orderRepo.findById(orderId).isPresent()) {
       orderRepo.deleteById(orderId);
        return "Order Cancel";
    }
     throw new OrderNotFoundException("Order does not exist!");
}
	@Override
	public List<Order> viewOrder() {
		List<Order> findAll = this.orderRepo.findAll();
		return findAll;
	}

	
	
}

