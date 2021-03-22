package com.smk.order.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author user
 *
 */
@Entity
//@Table(name="orders")

public class Orders implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2364908105502873949L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private String orderName;
	private Long inventoryId;
	private Integer quantity;
	private Float price;
	@Column(nullable = false, insertable = false)
	private LocalDateTime createTime;
	@Column(insertable = false)
	private LocalDateTime updateTime;

	/*
	 * @PrePersist protected void onCreate() { createTime = LocalDateTime.now(); }
	 * 
	 * @PreUpdate protected void onUpdate() { updateTime = LocalDateTime.now(); }
	 */
	public Orders() {
	}

//	public Orders(String orderName, Long inventoryId, Integer quantity, Float price) {
//		super();
//		this.orderName = orderName;
//		this.inventoryId = inventoryId;
//		this.quantity = quantity;
//		this.price = price;
//	}

	public Orders(Long orderId, String orderName, Long inventoryId, Integer quantity, Float price) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.inventoryId = inventoryId;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderName=" + orderName + ", inventoryId=" + inventoryId
				+ ", quantity=" + quantity + ", price=" + price + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}

}
