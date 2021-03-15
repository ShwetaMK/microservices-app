package com.smk.store.dto;

import java.time.LocalDateTime;

public class StoreDTO {

	private Long storeId;
	private String storeName;
	private Integer storeQuantity;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Integer getStoreQuantity() {
		return storeQuantity;
	}

	public void setStoreQuantity(Integer storeQuantity) {
		this.storeQuantity = storeQuantity;
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
		return "Store [storeId=" + storeId + ", storeName=" + storeName + ", storeQuantity=" + storeQuantity
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}
