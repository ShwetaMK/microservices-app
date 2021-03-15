package com.smk.order.service;

import java.util.List;

import com.smk.order.dto.OrderDTO;
import com.smk.order.dto.OrdersDTO;
import com.smk.order.model.Order;

public interface OrderService {

	// Get List of All order items
	public OrdersDTO getAllOrder();

	// Search Order item by using Id
	public OrdersDTO getOrderById(long orderId);

	// Add item into Order
	public OrderDTO addOrder(Order order);

	// Update Order item information
	public OrderDTO updateOrder(long orderId, Order order);

	// Delete order item
	public void deleteOrderById(long orderId);
}
