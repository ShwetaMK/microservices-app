package com.smk.order.service;

import com.smk.order.dto.OrderDTO;
import com.smk.order.dto.OrdersDTO;
import com.smk.order.model.Orders;

public interface OrderService {

	public OrdersDTO list();

	public OrdersDTO get(Long orderId);

	public OrderDTO save(Orders order);

//	public OrderDTO updateOrder(long orderId, Orders order);

	public void delete(Long orderId);
}
