package com.smk.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smk.order.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
