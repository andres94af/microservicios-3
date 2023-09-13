package com.andres.booking.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.booking.client.StockClient;
import com.andres.booking.dto.OrderDTO;
import com.andres.booking.entity.Order;
import com.andres.booking.repository.OrderRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private StockClient stockClient;
	
	@PostMapping("/order")
	@HystrixCommand(fallbackMethod = "fallbackToStockService")
	public String saveOrder(@RequestBody OrderDTO orderDTO) {
		
		boolean inStock = orderDTO.getOrderItems().stream()
				.allMatch(oi -> stockClient.stockAvailable(oi.getCode()));
		
		if (inStock) {
			Order order = new Order();
			order.setOrderNo(UUID.randomUUID().toString());
			order.setOrderITems(orderDTO.getOrderItems());
			orderRepository.save(order);
			return "Order Saved";			
		}
		return "Order Cannot be Saved";
	}
	
	private String fallbackToStockService() {
		return "Something went wrong, please try after some time.";
	}

}
