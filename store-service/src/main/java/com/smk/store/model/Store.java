package com.smk.store.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long storeId;
	private String storeName;
	private Integer storeQuantity;
	@Column(nullable = false)
	private LocalDateTime createTime;
	private LocalDateTime updateTime;

	@PrePersist
	protected void onCreate() {
		createTime = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		updateTime = LocalDateTime.now();
	}

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
