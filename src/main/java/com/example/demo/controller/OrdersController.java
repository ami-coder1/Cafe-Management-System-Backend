package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Orders;
import com.example.demo.service.ServiceImplementation;

@RestController
@RequestMapping("orders")
public class OrdersController {

	private ServiceImplementation si;

	@Autowired
	public OrdersController(ServiceImplementation si) {
		
		this.si = si;
	}
	
	@GetMapping("list")
	public List<Orders> displayAll()
	{
		return si.displayAllOrders();
	}
	
	@GetMapping("list/{orderId}")
	public Orders search(@PathVariable("orderId") int orderId) {
		
		return si.searchByOrderId(orderId);
	}
}
