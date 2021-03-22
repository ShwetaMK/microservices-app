package com.smk.order.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smk.order.dto.OrderDTO;
import com.smk.order.dto.OrdersDTO;
import com.smk.order.model.Orders;
import com.smk.order.repository.OrderRepository;
import com.smk.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public OrdersDTO get() {

		List<OrderDTO> orderDtos = ((List<Orders>) orderRepository.findAll()).stream()
				.map(o -> modelMapper.map(o, OrderDTO.class)).collect(Collectors.toList());
		OrdersDTO orders = new OrdersDTO();
		orders.setOrders((orderDtos));
		return orders;
	}

	@Override
	public OrdersDTO getOrderById(long orderId) {
		Orders order = orderRepository.findById(orderId).get();
		List<OrderDTO> ordersDtos = new ArrayList();
		ordersDtos.add(modelMapper.map(order, OrderDTO.class));
		OrdersDTO orders = new OrdersDTO();
		orders.setOrders((ordersDtos));
		return orders;
	}

	@Override
	public OrderDTO addOrder(Orders order) {
		Orders o = orderRepository.save(order);
		return modelMapper.map(o, OrderDTO.class);

	}

	@Override
	public OrderDTO updateOrder(long orderId, Orders order) {
		Orders oldOrder = orderRepository.findById(orderId).get();
		oldOrder.setQuantity(order.getQuantity());
		oldOrder.setStoreId(order.getStoreId());
		Orders o = orderRepository.save(oldOrder);
		return modelMapper.map(o, OrderDTO.class);
	}

	@Override
	public void deleteOrderById(long orderId) {
		orderRepository.deleteById(orderId);
	}

}
