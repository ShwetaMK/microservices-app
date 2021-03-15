package com.smk.store.dto;

import java.time.LocalDateTime;

public class OrderDTO {

	private Long orderId;
	private Integer storeId;
	private Integer quantity;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
		return "Order [orderId=" + orderId + ", storeId=" + storeId + ", quantity=" + quantity + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}

}
