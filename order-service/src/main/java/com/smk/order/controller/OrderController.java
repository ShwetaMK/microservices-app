package com.smk.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smk.order.dto.OrderDTO;
import com.smk.order.dto.OrdersDTO;
import com.smk.order.model.Order;
import com.smk.order.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping
	public ResponseEntity<OrdersDTO> getAllOrder() {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrder());

	}

	@GetMapping("/{orderId}")
	public ResponseEntity<OrdersDTO> getOrderByid(@PathVariable int orderId) throws NotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderById(orderId));

	}

	@PostMapping
	public ResponseEntity<OrderDTO> addOrder(@RequestBody Order order) {

		return ResponseEntity.status(HttpStatus.OK).body(orderService.addOrder(order));

	}

	@PutMapping("{orderId}")
	public ResponseEntity<OrderDTO> updateOrder(@PathVariable int orderId, @RequestBody Order order) {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrder(orderId, order));

	}

	@DeleteMapping("{orderId}")
	public ResponseEntity<String> deleteOrderById(@PathVariable long orderId) {
		orderService.deleteOrderById(orderId);
		return ResponseEntity.status(HttpStatus.OK).body("");

	}

	 
}
