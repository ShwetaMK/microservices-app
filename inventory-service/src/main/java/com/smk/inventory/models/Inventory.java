package com.smk.inventory.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Entity
public class Inventory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2298375083377697514L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inventoryId;
	@Column(nullable = false)
	private String inventoryName;
//	@Column(nullable = false)
//	@Min(message = "Price cannot be negative",value = 0)
	@NotNull
	@PositiveOrZero
	private Integer quantity;
	@Column(nullable = false,updatable = false)
	private LocalDateTime createTime;
	@Column(insertable = false)
	private LocalDateTime updateTime;

	@PrePersist
	protected void onCreate() {
		createTime = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		updateTime = LocalDateTime.now();
	}
//
//	public Inventory() {
//		super();
//	}
//
////	public Inventory(String inventoryName, Integer quantity, LocalDateTime createTime, LocalDateTime updateTime) {
////		super();
////		this.inventoryName = inventoryName;
////		this.quantity = quantity;
////		this.createTime = createTime;
////		this.updateTime = updateTime;
////	}
//
//	public Inventory(Long inventoryId, String inventoryName, Integer quantity, LocalDateTime createTime,
//			LocalDateTime updateTime) {
//		super();
//		this.inventoryId = inventoryId;
//		this.inventoryName = inventoryName;
//		this.quantity = quantity;
//		this.createTime = createTime;
//		this.updateTime = updateTime;
//	}
//
//	public Long getInventoryId() {
//		return inventoryId;
//	}
//
//	public void setInventoryId(Long inventoryId) {
//		this.inventoryId = inventoryId;
//	}
//
//	public String getInventoryName() {
//		return inventoryName;
//	}
//
//	public void setInventoryName(String inventoryName) {
//		this.inventoryName = inventoryName;
//	}
//
//	public Integer getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(Integer quantity) {
//		this.quantity = quantity;
//	}
//
//	public LocalDateTime getcreateTime() {
//		return createTime;
//	}
//
//	public void setcreateTime(LocalDateTime createTime) {
//		this.createTime = createTime;
//	}
//
//	public LocalDateTime getUpdateTime() {
//		return updateTime;
//	}
//
//	public void setUpdateTime(LocalDateTime updateTime) {
//		this.updateTime = updateTime;
//	}
//
//	@Override
//	public String toString() {
//		return "Inventory [inventoryId=" + inventoryId + ", inventoryName=" + inventoryName + ", quantity=" + quantity
//				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
//	}

}